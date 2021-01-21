package com.example.level5task1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class EditViewModel(application: Application) : AndroidViewModel(application) {
    private val gameRepository = NoteRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    var note: Note? = null
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()

    fun addGame() {
        if (isGameValid()) {
            mainScope.launch {
                withContext(Dispatchers.IO) {
                    note?.let { gameRepository.insertGame(it) }
                }
                success.value = true
            }
        }
    }

    private fun isGameValid(): Boolean {
        return when {
            note == null -> {
                error.value = "Game must not be null"
                false
            }
            note?.title.isNullOrBlank() -> {
                error.value = "Title must not be null or empty"
                false
            }
            note?.platform.isNullOrBlank() -> {
                error.value = "Platform must not be null or empty"
                false
            }
            note?.releaseDate == null -> {
                error.value = "Date is invalid"
                false
            }
            else -> true
        }
    }

    fun tryGetDate(day: String, month: String, year: String) : Date?
    {
        return try {
            val cal = Calendar.getInstance()
            cal.isLenient = false
            cal.set(day.toInt(), month.toInt() - 1, year.toInt())
            cal.time
        } catch (e: Exception) {
            null
        }

    }
}