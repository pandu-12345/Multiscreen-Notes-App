package com.example.frag3.Data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fragment_app.Data.Entity.Notes
import com.example.fragment_app.Data.Notedao.NoteDAO


@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase() {
    abstract fun getNoteDao(): NoteDAO


}