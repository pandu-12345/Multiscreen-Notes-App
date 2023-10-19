package com.example.fragment_app.Data.Notedao

import com.example.fragment_app.Data.Entity.Notes
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDAO{
    @Insert
    suspend fun addNotes(note: Notes)

    @Delete
    suspend fun deleteNotes(notes: Notes)

    @Update
    suspend fun update(note: Notes)

    @Query("SELECT * FROM NOTES_LIST")
    fun getData():LiveData<List<Notes>>
}