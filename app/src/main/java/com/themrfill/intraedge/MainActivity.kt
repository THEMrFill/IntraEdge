package com.themrfill.intraedge

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.themrfill.intraedge.data.NumberManager
import com.themrfill.intraedge.databinding.ActivityMainBinding
import com.themrfill.intraedge.list.EntriesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.themrfill.intraedge.vm.ListViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: ListViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private val adapter = EntriesAdapter()

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with (binding) {
            recycler.layoutManager = LinearLayoutManager(this@MainActivity)
            recycler.adapter = adapter

            button.setOnClickListener { viewModel.addEntry(NumberManager.createNewNumber()) }
        }

        setupObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.entriesList.value?.let {
            if (it.size > 0) {
                adapter.setData(it)
            }
        }
    }

    private fun setupObservers() {
        viewModel.newEntry.observe(this) { entry ->
            adapter.addEntry(entry)
            binding.recycler.smoothScrollToPosition(0)
        }
    }
}