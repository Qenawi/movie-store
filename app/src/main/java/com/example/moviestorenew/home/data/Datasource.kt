package com.example.moviestorenew.home.data

class Datasource {
    companion object {
        fun getMovies(): List<Movie> {
            return listOf<Movie>(
                Movie(
                    "Jurassic World Dominion",
                    "https://m.media-amazon.com/images/M/MV5BOTBjMjA4NmYtN2RjMi00YWZlLTliYTktOTIwMmNkYjYxYmE1XkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_QL75_UY562_CR5,0,380,562_.jpg-"
                ),
                Movie(
                    "Spider-Man: No Way Home",
                    "https://m.media-amazon.com/images/M/MV5BZWMyYzFjYTYtNTRjYi00OGExLWE2YzgtOGRmYjAxZTU3NzBiXkEyXkFqcGdeQXVyMzQ0MzA0NTM@._V1_QL75_UX380_CR0,0,380,562_.jpg"
                )
            )
        }
    }
}