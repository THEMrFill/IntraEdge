package com.themrfill.intraedge.di

import com.themrfill.intraedge.vm.ListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    viewModelOf(::ListViewModel)

}