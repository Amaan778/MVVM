package com.app.mvvmproject

import androidx.lifecycle.LiveData

class NotesRepository(private val notesDao: NotesDao) {

    suspend fun insertNotes(notes: Notes){
        notesDao.insertnotes(notes)
    }

    fun getnotes():LiveData<List<Notes>>{
        return notesDao.getnotes()
    }

}