package student;

import java.util.ArrayList;

// 자바로 라이브러리 (기능) 함수 만들기
// 클래스 기능 (메서드)
public class MyUtil {
	
	public ArrayList<Integer> getDivisor(int num){
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                result.add(i);
            }
        }
		
		return result;
	}


}
