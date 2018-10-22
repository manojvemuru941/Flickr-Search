package com.flickr.gallery.ui.flickr.fav

import android.view.View
import com.flickr.gallery.ui.flickr.base.ListFragmentViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Manoj Vemuru on 2018-10-21.
 */
class FavListFragmentViewModel : ListFragmentViewModel() {
    override val errorClickListener = View.OnClickListener {
        loadFav()
    }

    init {
        loadFav()
    }

    private fun loadFav() {
        subscription = Observable.fromCallable { favImageDao.all }
                .concatMap {
                    dbFavImages ->
                    Observable.just(dbFavImages)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveListStart() }
                .doOnTerminate { onRetrieveListFinish() }
                .subscribe(
                        { onRetrieveImages(it)},
                        {err -> onRetrieveListError(err)}
                )
    }

}