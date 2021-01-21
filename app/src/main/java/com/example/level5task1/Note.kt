package com.example.level5task1

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity(tableName = "note_table")
data class Note(
    var title: String,
    var platform: String,
    var releaseDate: Date?,

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
)