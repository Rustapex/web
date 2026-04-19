package day03Prac.mvc;

public class 구구단서비스 {
	
	public String[] getDan3() {
		String[] dan3 = new String[9];
		
		for(int i=1; i<10; i++) {
			String dans = "";
			dans +="3 x " + i + " = " + 3*i;
			dan3[i-1] = dans;
		}
		
		return dan3;
	}
	
	public static void main(String[] args) {
		구구단서비스 service = new 구구단서비스();
		for(String dans : service.getDan3()) {
			System.out.println();
		}
	}
	
	

}
