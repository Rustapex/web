package movie;

import java.util.ArrayList;

public class MovieService {
	
	MovieDAO dao = new MovieDAO();
	
	public ArrayList<Movie> getMovieList(){
		return dao.findAll();
	}

}
