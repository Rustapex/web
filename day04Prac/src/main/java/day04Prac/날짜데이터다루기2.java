package day04Prac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class 날짜데이터다루기2 {
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
			e.printStackTrace();
			
		}
		
		System.out.println("정상종료");
		
//		Date 현재 날짜 가져오기
		Date now = new Date();
		System.out.println(now);
		
//		연 월 일 얻오기
		Calendar cal = Calendar.getInstance(); //static method , 
		System.out.println(Calendar.YEAR);
		System.out.println((Calendar.MONTH) + 1); // 월은 0부터
		
		
		System.out.println("LocalDate ");
//		
		LocalDate today = LocalDate.now();
		System.out.println(today.getYear());
		System.out.println(today.getMonth());
		System.out.println(today.getDayOfWeek());
		
	}

}
