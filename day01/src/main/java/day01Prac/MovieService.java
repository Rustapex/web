package day01Prac;

import java.util.ArrayList;

public class MovieService {
	
	ArrayList<Movie2> list = new ArrayList<>();

	// 생성자
	public MovieService() {
		list.add(new Movie2("avator", 5));
		list.add(new Movie2("nowYouSeeMe2", 4));
	}
	
	// 추가하기
	public void addMovie(Movie2 movie) {
		list.add(movie);
	}
	
	// 조회하기
	public Movie2 getMovie(String title) {
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	// 삭제하기
	public boolean removeMovie(String title) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				list.remove(list.get(i));
				return true;
			}
		}
		return false;
	}
	
	// 수정하기
	public boolean updateMovie(String title, String newTitle, int newStar) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				list.get(i).setTitle(newTitle);
				list.get(i).setReviewStar(newStar);
				return true;
			}
		}
		return false;
	}
	
	
	
	
	

}
