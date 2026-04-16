package day01Prac;

public class Movie2{
	String title;
	int reviewStar;
	
	
	public Movie2(String title, int reviewStar) {
		super();
		this.title = title;
		this.reviewStar= reviewStar;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}

	@Override
	public String toString() {
		return "Movie2 [title=" + title + ", reviewStar=" + reviewStar + "]";
	}

	
	
	
	
}