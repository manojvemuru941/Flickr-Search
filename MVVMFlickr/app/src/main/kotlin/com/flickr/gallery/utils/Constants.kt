package com.flickr.gallery.utils

import android.content.Context

/** The base URL of the API */
const val BASE_URL: String = "https://jsonplaceholder.typicode.com"

private var _context:Context? = null

fun INIT (context: Context) {
    _context = context
}

fun getStringResource(resId : Int) :String {
    return _context!!.getString(resId)
}