package com.flickr.gallery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */
class FlickrImages {
    @SerializedName("page")
    @Expose
    private var page: Int? = null
    @SerializedName("pages")
    @Expose
    private var pages: Int? = null
    @SerializedName("perpage")
    @Expose
    private var perpage: Int? = null
    @SerializedName("total")
    @Expose
    private var total: Int? = null
    @SerializedName("photo")
    @Expose
    private var image: List<FlickrImage>? = null

    fun getPage(): Int? {
        return page
    }

    fun setPage(page: Int?) {
        this.page = page
    }

    fun getPages(): Int? {
        return pages
    }

    fun setPages(pages: Int?) {
        this.pages = pages
    }

    fun getPerpage(): Int? {
        return perpage
    }

    fun setPerpage(perpage: Int?) {
        this.perpage = perpage
    }

    fun getTotal(): Int? {
        return total
    }

    fun setTotal(total: Int?) {
        this.total = total
    }

    fun getImage(): List<FlickrImage>? {
        return image
    }

    fun setImage(image: List<FlickrImage>) {
        this.image = image
    }
}