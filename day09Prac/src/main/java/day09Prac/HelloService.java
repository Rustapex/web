package day09Prac;

public class HelloService {
	
	public int getLength(String str) throws Exception{
		
		int cnt =0;
		
		try {
			cnt = str.length(); // 예외 발생 가능 코드
		} catch(Exception e) {	// exception 계열, runtime Exception 
			System.out.println(e.getMessage());
			throw e; 	// 예외 다시 일으키기  -> 상위에게 예외 전파
		}
		
		return cnt;
	}

}
