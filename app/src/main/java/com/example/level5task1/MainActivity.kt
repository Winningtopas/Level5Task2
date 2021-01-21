package com.example.level5task1

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.level5task1.MainActivityViewModel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initViews()
        //initViewModel()
    }

    private fun initViews() {
        fab.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_remove_all -> {
                mainActivityViewModel.deleteAllGames(rvGames)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
