package com.example.felipe.pipemovies.action

import com.example.felipe.pipemovies.model.Movielist

sealed class PipeActions {

    class RetriveMovielist(val movielist: Movielist):PipeActions()
}