package com.flickr.gallery.ui.flickr

import android.app.SearchManager
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.flickr.gallery.R
import com.flickr.gallery.databinding.MainActivityBinding
import com.flickr.gallery.injection.ViewModelFactory


class FlickrImageListActivity: AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    private lateinit var recentImagesFragment: FlickrRecentListFragment
    private lateinit var viewModel: FlickrImageListViewModel

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        binding.bottomNavigation.selectedItemId = R.id.recent_images
        recentImagesFragment = FlickrRecentListFragment.newInstanceRecentImagesFragment()
        recentImagesFragment.retainInstance = true
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, recentImagesFragment).commit()
        binding.bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelected)

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(FlickrImageListViewModel::class.java)

        handleIntent(intent)
    }

    /**
     * Handles intent action
     */
    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            doSearchQuery(query)
        }

    }

    /**
     * Provides Entry point for Single Top Activity
     * @param intent intent action
     */
    override fun onNewIntent(intent: Intent) {
        setIntent(intent)
        handleIntent(intent)
    }

    /**
     * Initiates Search Fragment with query
     * @param query string query
     */
    private fun doSearchQuery(query: String) {
       val recentTagImagesFragment = FlickrSearchListFragment.newInstanceRecentImagesFragment(query)
        recentTagImagesFragment.retainInstance = true
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, recentTagImagesFragment).commit()
    }

    /**
     * listener for Navigation Item Selected
     */
   private val onNavigationItemSelected: BottomNavigationView.OnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.recent_images -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, recentImagesFragment).commit()
            }
            R.id.search_images -> {
                onSearchRequested()
            }
        }
        true
    }
}