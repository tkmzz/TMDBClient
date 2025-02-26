package com.luiz.tmdbclient.presentation.tvshow

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.luiz.tmdbclient.R
import com.luiz.tmdbclient.databinding.ActivityTvshowsBinding
import com.luiz.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class TvshowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvshowViewModelFactory
    private lateinit var tvShowViewModel: TvshowViewModel
    private lateinit var binding: ActivityTvshowsBinding
    private lateinit var adapter: TvshowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tvshows)
        (application as Injector).createTvshowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)
            .get(TvshowViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.tvshowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvshowAdapter()
        binding.tvshowRecyclerView.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvshows()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE
            } else {
                binding.tvshowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows() {
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvshows()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE
            } else {
                binding.tvshowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT)
            }
        })
    }
}