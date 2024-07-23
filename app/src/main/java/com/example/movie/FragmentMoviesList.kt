package com.example.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movie.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment() {

    private lateinit var binding: FragmentMoviesListBinding
    private lateinit var adapter: MovieAdapter

    private val movieCardsService: MovieCardsService
        get() = (requireContext().applicationContext as App).movieCardsService


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesListBinding.inflate(inflater, container, false)

        val layoutManager = GridLayoutManager(requireContext(), 2)


        adapter = MovieAdapter(object : MovieCardActionListener {
            override fun onMovieCardMove(movieCard: MovieCard, moveBy: Int) {
                movieCardsService.moveMovieCard(movieCard, moveBy)
            }

            override fun onMovieCardDelete(movieCard: MovieCard) {
                movieCardsService.deleteMovieCard(movieCard)
            }

            override fun onMovieCardDetails(movieCard: MovieCard) {
                Toast.makeText(
                    requireContext(),
                    "MovieCard: ${movieCard.movieName}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        binding.rvMoviesList.layoutManager = layoutManager
        binding.rvMoviesList.adapter = adapter

        movieCardsService.addListener(movieCardsListener)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        movieCardsService.removeListener(movieCardsListener)
    }

    private val movieCardsListener: MovieCardsListener = { movieCards ->
        adapter.movieCards = movieCards
    }
}