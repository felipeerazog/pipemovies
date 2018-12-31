package com.example.felipe.pipemovies.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.felipe.pipemovies.R
import com.example.felipe.pipemovies.action.PipeActions
import com.example.felipe.pipemovies.model.Movielist
import com.example.felipe.pipemovies.viewmodel.MovielistViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import android.databinding.DataBindingUtil
import com.example.felipe.pipemovies.databinding.ActivityMainBinding


class MainActivity() : AppCompatActivity() {

    val compositeDisposable = CompositeDisposable()
    val viewModel = MovielistViewModel()

    // databindind initialization
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindSubscription()

        viewModel.getMovielist()
    }

    private fun bindSubscription() {
        compositeDisposable.add(viewModel.observablePublishSubject()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::eventListener)
        )
    }

    fun eventListener(action: PipeActions) {
        when(action) {
            is PipeActions.RetriveMovielist -> populate(action.movielist)
        }
    }

    fun populate(movielist: Movielist){
        binding.movielist = movielist
    }

}
