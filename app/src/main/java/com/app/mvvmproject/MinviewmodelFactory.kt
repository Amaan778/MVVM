package com.app.mvvmproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MinviewmodelFactory(private val notesRepository: NotesRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(notesRepository) as T
    }
}