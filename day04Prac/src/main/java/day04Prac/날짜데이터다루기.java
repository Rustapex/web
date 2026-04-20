package day04Prac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 날짜데이터다루기 {
	public static void main(String[] args) throws ParseException {
		String id="hee";
		String pw="1234";
		String name = "스윙스";
		int point = 5000;
		Date birth = null;
		
//		String -> Date 형변환
//		"1999-10-10"
		
		String strBirth = "1999-10-10";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd"); 
		
		try {
			sf.parse(strBirth);
		} catch (ParseException e) {
//			e.printStackTrace();
			System.out.println("날짜 형식이 맞지 않습니다.");
//			예외 상황 인식, 처리 후 예외 다시 일으키기
			throw e;
		}
		
		System.out.println("정상종료");
	}

}
