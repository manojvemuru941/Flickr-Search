package com.flicker.image.gallery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.flicker.image.gallery.ui.main.MainFragment

/**
 * Created by Manoj Vemuru on 2018-10-19.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
