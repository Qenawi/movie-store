package com.example.moviestorenew.home.data

class Datasource {
    companion object {
        fun getTopMovies(): List<Movie> {
            return getMovies()
        }

        fun getMovies(): List<Movie> {
            return listOf(
                Movie(
                    "The Godfather",
                    "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_QL75_UY562_CR8,0,380,562_.jpg",
                    "Crime",
                    1972,
                    175
                ),
                Movie(
                    "The Shawshank Redemption",
                    "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_QL75_UX380_CR0,1,380,562_.jpg",
                    "Drama",
                    1994,
                    142
                ),
                Movie(
                    "Jurassic World Dominion",
                    "https://m.media-amazon.com/images/M/MV5BOTBjMjA4NmYtN2RjMi00YWZlLTliYTktOTIwMmNkYjYxYmE1XkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_QL75_UY562_CR5,0,380,562_.jpg-",
                    "Action",
                    2022,
                    147
                ),
                Movie(
                    "Spider-Man: No Way Home",
                    "https://m.media-amazon.com/images/M/MV5BZWMyYzFjYTYtNTRjYi00OGExLWE2YzgtOGRmYjAxZTU3NzBiXkEyXkFqcGdeQXVyMzQ0MzA0NTM@._V1_QL75_UX380_CR0,0,380,562_.jpg",
                    "Action",
                    2021,
                    148
                )
            )
        }
    }
}