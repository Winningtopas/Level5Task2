package com.example.level5task1

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.level5task1.Note

class NoteRepository(context: Context) {

    private val noteDao: NoteDao?

    init {
        val database = NotepadRoomDatabase.getDatabase(context)
        noteDao = database?.noteDao()
    }

    fun getAllGames(): LiveData<List<Note>> = noteDao?.getAllGames() ?: MutableLiveData(emptyList())
    suspend fun deleteAllGames() = noteDao?.deleteAllGames()
    suspend fun insertGame(note: Note) = noteDao?.insertGame(note)
    suspend fun deleteGame(note: Note) = noteDao?.deleteGame(note)

}