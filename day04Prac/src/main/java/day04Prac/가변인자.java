package day04Prac;

public class 가변인자 {
	
	public void printStr(String str) {
		System.out.println(str);
	}

	public void printStr2(String str1, String str2) {
		System.out.println(str1);
		System.out.println(str2);

	}

	public void printStr3(String ...a) {
		for(String s : a) {
			System.out.println(s);
		}
		
	}

	public static void main(String[] args) {
		
//		크기가 0인 배열 만들기
		int[] arr= new int[0];
		
		
		
		가변인자 m = new 가변인자();
		
		m.printStr3("안녕");
		
		m.printStr3("여러", "개를", "출력", "할수", "있어");
	}

}
