package com.example.frag3.ui.repositry

import androidx.lifecycle.LiveData
import com.example.fragment_app.Data.Entity.Notes
import com.example.fragment_app.Data.Notedao.NoteDAO
import javax.inject.Inject

class NotesRepositry @Inject constructor(private val notesDao: NoteDAO) {
   fun getallData():LiveData<List<Notes>> = notesDao.getData()
    suspend fun insert(notes: Notes)=notesDao.addNotes(notes)
    suspend fun delete(notes: Notes)=notesDao.deleteNotes(notes)
    suspend fun update(notes: Notes)=notesDao.update(notes)

}