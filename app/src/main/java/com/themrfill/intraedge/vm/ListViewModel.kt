package com.themrfill.intraedge.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel() {
    private val _entriesList = MutableLiveData<ArrayList<String>>()
    val entriesList: LiveData<ArrayList<String>> = _entriesList
    private val _entriesMap = HashMap<String, Boolean>()

    private val _newEntry = MutableLiveData<String>()
    val newEntry: LiveData<String> = _newEntry

    fun addEntry(entry: String): Boolean {
        if (_entriesMap.containsKey(entry))
            return false
        _entriesMap[entry] = true
        _entriesList.value?.add(entry)
        _newEntry.value = entry
        return true
    }

}