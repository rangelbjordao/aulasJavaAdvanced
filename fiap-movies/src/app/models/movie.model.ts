export interface Movie {
  id: number;
  title: string;
  synopsis: string;
  rating: number;
  posterUrl: string;
}

export interface MovieResponse {
  _embedded: {
    movies: Movie[];
  };
}
