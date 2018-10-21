package com.flickr.gallery.ui.flickr.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.flickr.gallery.R
import com.flickr.gallery.databinding.ItemImageBinding
import com.flickr.gallery.model.FlickrImage
import com.flickr.gallery.model.FlickrImages
import com.flickr.gallery.ui.flickr.ImageViewModel

class FlickrImageListAdapter: RecyclerView.Adapter<FlickrImageListAdapter.ViewHolder>() {
    private lateinit var imageList:List<FlickrImage>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemImageBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_image, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    /**
     * Provides number of items to recycler Adapter
     * @return return count
     */
    override fun getItemCount(): Int {
        return if(::imageList.isInitialized) imageList.size else 0
    }

    /**
     * Updates images list
     * @param flickrImages list of flickr Images
     */
    fun updateImageList(listImages: List<FlickrImage>){
        this.imageList = listImages
        notifyDataSetChanged()
    }

    fun getImageList() : List<FlickrImage> {
        return this.imageList
    }

    class ViewHolder(private val binding: ItemImageBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = ImageViewModel()

        fun bind(post:FlickrImage){
            viewModel.bind(post)
            binding.viewModel = viewModel
        }
    }
}