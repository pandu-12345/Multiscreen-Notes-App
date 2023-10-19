package com.example.frag3.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragment_app.Data.Entity.Notes
import com.example.frag3.ui.repositry.NotesRepositry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NotesViewModel @Inject constructor(
   private val notesRepositry: NotesRepositry
):ViewModel() {

    val allNotes:LiveData<List<Notes>> =notesRepositry.getallData()
   fun insert(notes: Notes){
        viewModelScope.launch {
            notesRepositry.insert(notes)
        }
    }
    fun update(notes: Notes)=viewModelScope.launch {
            notesRepositry.update(notes)
        }

    fun delete(notes: Notes){
        viewModelScope.launch {
            notesRepositry.delete(notes)
        }
    }
}