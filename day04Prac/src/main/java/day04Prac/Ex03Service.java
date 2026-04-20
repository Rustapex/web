package day04Prac;

public class Ex03Service {
	
	// 학생 성적 가져오기
	public Score getScore() {
		Score score = new Score();
		return score;
	}
	
	public static void main(String[] args) {
		Ex03Service e = new Ex03Service();
		Score s = e.getScore();
		
		System.out.println(s.toString());
		System.out.println(s.getEng());
		System.out.println(s.getKor());

	}

}
