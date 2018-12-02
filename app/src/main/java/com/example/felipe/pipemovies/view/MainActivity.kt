package com.example.felipe.pipemovies.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.felipe.pipemovies.R
import com.example.felipe.pipemovies.action.PipeActions
import com.example.felipe.pipemovies.model.Movielist
import com.example.felipe.pipemovies.service.MovielistService
import com.example.felipe.pipemovies.viewmodel.MovielistViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.mTextView
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity() : AppCompatActivity() {

    val compositeDisposable = CompositeDisposable()
    val viewModel = MovielistViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindSubscription()
        viewModel.getMovielist()
    }

    fun bindSubscription() {
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
        var sb = StringBuilder()
        sb.append(movielist.totalPages)
        mTextView.text = sb.toString()
    }
}
