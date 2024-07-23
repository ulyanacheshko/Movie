package com.example.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.databinding.FragmentMoviesItemBinding

  interface MovieCardActionListener {

    fun onMovieCardMove(movieCard: MovieCard, moveBy: Int)

    fun onMovieCardDelete(movieCard: MovieCard)

    fun onMovieCardDetails(movieCard: MovieCard)

}
  class MovieAdapter(
    private val actionListener: MovieCardActionListener
  ) : RecyclerView.Adapter<MovieAdapter.MovieCardsViewHolder>(), View.OnClickListener {


    var movieCards: List<MovieCard> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onClick(v: View) {
        val movieCard = v.tag as MovieCard
        when (v.id) {
            R.id.imMovieImage -> {
                //showPopupMenu(v)
            }
            else -> {
                actionListener.onMovieCardDetails(movieCard)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCardsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentMoviesItemBinding.inflate(inflater,parent,false)

        binding.root.setOnClickListener(this)
        binding.imMoreInfo.setOnClickListener(this)

        return MovieCardsViewHolder(binding)
    }

    override fun getItemCount(): Int = movieCards.size

    override fun onBindViewHolder(holder: MovieCardsViewHolder, position: Int) {
        val movieCard = movieCards[position]
        with(holder.binding) {
            holder.itemView.tag = movieCard
            imMoreInfo.tag = movieCard
            tvAgeLimit.text = movieCard.ageLimit
            tvTeg.text = movieCard.teg
            tvReviews.text = movieCard.reviews
            tvMovieName.text = movieCard.movieName
            tvDuration.text = movieCard.duration
            if (movieCard.movieImage.isNotBlank()) {
                Glide.with(imMovieImage.context)
                    .load(movieCard.movieImage)
                    .placeholder(R.drawable.baseline_autorenew_24)
                    .error(R.drawable.baseline_autorenew_24)
                    .into(imMovieImage)
            } else {
                Glide.with(imMovieImage.context).clear(imMovieImage)
               imMovieImage.setImageResource(R.drawable.baseline_autorenew_24)
            }
        }
    }

    class MovieCardsViewHolder(
        val binding: FragmentMoviesItemBinding
    ): RecyclerView.ViewHolder(binding.root)



}
