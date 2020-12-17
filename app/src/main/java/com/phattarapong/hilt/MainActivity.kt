package com.phattarapong.hilt

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.phattarapong.hilt.database.CharacterLocal
import com.phattarapong.hilt.network.Result
import com.phattarapong.hilt.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.characterList.observe(this) {
            if (it is Result.Success) {
                Log.d(TAG, "onCreate: ${it.data.size}")
            }
        }
        setUpObserveData()
    }

    private fun setUpObserveData() {
        viewModel.characterList.observe(this) {
            if (it is Result.Loading) {
                loadingLayout.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            } else if (it is Result.Success) {
                loadingLayout.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                setUpAdapter(it.data)
            } else if (it is Result.Error) {
                loadingLayout.visibility = View.GONE
                recyclerView.visibility = View.GONE
                Snackbar.make(contentLayout, it.msg, Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun setUpAdapter(it: List<CharacterLocal>) {
        CharacterAdapter(it).apply {
            recyclerView.adapter = this
            recyclerView.layoutManager =
                LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }
    }
}