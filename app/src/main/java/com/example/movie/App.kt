package com.example.movie

import android.app.Application

class App: Application() {
    val movieCardsService = MovieCardsService()
}