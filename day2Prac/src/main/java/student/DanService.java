package student;

import java.util.ArrayList;

public class DanService {
	
	public ArrayList<Integer> getDan(int num){
		MyUtil util = new MyUtil();
		return util.getDivisor(num);
	}

}
