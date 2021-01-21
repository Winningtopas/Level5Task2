package com.example.level5task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_edit.view.*
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.SimpleDateFormat
import java.util.*

class GameAdapter(private val games: List<Note>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    var formatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(note: Note){
            itemView.tvTitle.text = note.title
            itemView.tvPlatform.text = note.platform
            itemView.tvReleaseDate.text = itemView.context.getString(R.string.release_date, formatter.format(note.releaseDate))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false))
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }

}