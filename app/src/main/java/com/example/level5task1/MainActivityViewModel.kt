package com.example.level5task1

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.level5task1.NoteRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val noteRepository = NoteRepository(application.applicationContext)

    val notes: LiveData<List<Note>> = noteRepository.getAllGames()
    //val note = noteRepository.getNotepad()

    fun deleteAllGames(view: View) {
        val beforeGames = notes.value
        ioScope.launch {
            noteRepository.deleteAllGames()
        }
        val snackBar = Snackbar.make(view, R.string.delete_all_succeed, Snackbar.LENGTH_LONG)

        snackBar.show()
    }
}