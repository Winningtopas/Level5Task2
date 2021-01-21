package com.example.level5task1

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table ORDER BY releaseDate ASC")
    fun getAllGames(): LiveData<List<Note>>

    @Query("DELETE FROM note_table")
    suspend fun deleteAllGames()

    @Insert
    suspend fun insertGame(game: Note)

    @Delete
    suspend fun deleteGame(game: Note)

}