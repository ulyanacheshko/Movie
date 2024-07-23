package com.example.movie

data class MovieCard(
    val id:Long,
    val movieName:String,
    val movieImage:String,
    val teg:String,
    val reviews:String,
    val duration:String,
    val ageLimit:String
)
fun generateMoviesCards(): List<MovieCard> {
    return listOf(
        MovieCard(1,"Avengers: End Game", "movie1", "Action, Adventure, Drama",
            "125 reviews", "137 min", "13+"),
        MovieCard(2,"Tenet", "movie2", "Action, Sci-Fi, Thriller",
            "98 reviews", "97 min", "16+"),
        MovieCard(3,"Black Widow", "movie3", "Action, Adventure, Sci-Fi",
            "38 reviews", "125 min", "13+"),
        MovieCard(4,"Wonder Woman 1984", "movie4", "Action, Adventure, Fantasy",
            "74 reviews", "120 min", "13+")
    )
}
