package com.example.movie

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val movieName: TextView = itemView.findViewById(R.id.tv_movieName)
    private val movieImage: ImageView = itemView.findViewById(R.id.imMovieImage)
    private val teg: TextView = itemView.findViewById(R.id.tv_teg)
    private val reviews: TextView = itemView.findViewById(R.id.tv_reviews)
    private val duration: TextView = itemView.findViewById(R.id.tv_duration)
    private val ageLimit: TextView = itemView.findViewById(R.id.tv_ageLimit)

    fun bind(movieCard: MovieCard) {
        movieName.text = movieCard.movieName
        teg.text = movieCard.teg
        reviews.text = movieCard.reviews
        duration.text = movieCard.duration
        ageLimit.text = movieCard.ageLimit

        val context = itemView.context
        val imageResourceId = context.resources.getIdentifier(movieCard.movieImage, "drawable", context.packageName)
        Glide.with(context)
            .load(imageResourceId)
            .into(movieImage)
    }
    private fun loadImageFromResource(imageResource: String, imageView: ImageView) {
        val context = imageView.context
        val resourceId = context.resources.getIdentifier(
            imageResource, "drawable", context.packageName
        )
        Glide.with(context).load(resourceId).into(imageView)
    }
}