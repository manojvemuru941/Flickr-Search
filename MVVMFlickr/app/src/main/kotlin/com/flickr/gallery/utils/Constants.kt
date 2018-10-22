package com.flickr.gallery.utils

import android.content.Context
import java.text.DateFormat
import java.text.SimpleDateFormat

const val SEARCH_KEY:String = "search"
const val VIEW_KEY:String = "view"
const val METHOD_NAME_RECENT:String = "flickr.photos.getRecent"
const val METHOD_NAME_SEARCH:String = "flickr.photos.search"
const val FORMAT:String = "json"
const val NO_JSON_CALL_BACK:Int = 1
const val EXTRAS:String = "url_s,date_upload,date_taken,owner_name"
val DATE_FORMATTER : DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
const val SORT_TAKEN:Int = 0
const val SORT_UPLOADED:Int = 1

private var _context:Context? = null

fun INIT (context: Context) {
    _context = context
}

/**
 * Provides String from resources
 */
fun getStringResource(resId : Int) :String {
    return _context!!.getString(resId)
}

/**
 * Provides App Context
 */
fun getAppContext() : Context {
    return _context!!
}