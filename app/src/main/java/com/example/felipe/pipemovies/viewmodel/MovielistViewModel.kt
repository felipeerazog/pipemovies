package com.example.felipe.pipemovies.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.felipe.pipemovies.action.PipeActions
import com.example.felipe.pipemovies.datamodel.MovielistDataModel
import com.example.felipe.pipemovies.model.Movie
import com.example.felipe.pipemovies.model.Movielist
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class MovielistViewModel {

    private val publishSubject: PublishSubject<PipeActions> = PublishSubject.create()

    companion object {
        private const val TAG = "MovielistViewModel"
    }

    fun getMovielist() {
        val dataModel = MovielistDataModel()
        dataModel.getMovielist()
                .subscribeOn(Schedulers.io())
                .subscribe(this::populate, this::errorService)
    }

    fun populate(movielist: Movielist) {
        publishSubject.onNext(PipeActions.RetriveMovielist(movielist))
    }

    private fun errorService(error: Throwable) {
        Log.d(TAG, error.message)
    }

    fun observablePublishSubject(): Observable<PipeActions> {
        return publishSubject.hide()
    }

}