package com.example.frag3

import android.content.Context
import androidx.room.Room
import com.example.fragment_app.Data.Notedao.NoteDAO
import com.example.frag3.Data.database.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object module {
    @Provides
    @Singleton
    fun roomDatabase(@ApplicationContext context: Context): NotesDatabase =Room.databaseBuilder(context,
        NotesDatabase::class.java,"Database").build()

    @Provides
    @Singleton
    fun provideNoteDao(db: NotesDatabase):NoteDAO=db.getNoteDao()
}