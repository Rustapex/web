package prac02;

import java.util.ArrayList;

public class Q3Dan {
	
	
	public ArrayList<String> dan(int dan) {
		ArrayList<String> danRes = new ArrayList<>();
		
		for(int i=1; i<=9;i++) {
			String danStr = "";
			danStr = dan + " x " +  i +" = " +  dan*i;
			danRes.add(danStr);
		}
		return danRes;
	}

	

	

}
