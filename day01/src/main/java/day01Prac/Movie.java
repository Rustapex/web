package day01Prac;

public class Movie{
	String title;
	String director;
	String genre;
	int runningTime;
	
	public Movie(String title, String director, String genre, int runningTime) {
		super();
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", genre=" + genre + ", runningTime=" + runningTime
				+ "]";
	}
	
	
	
}