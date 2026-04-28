package ELJSTL;

import java.util.ArrayList;

public class AcornService {
	
	public ArrayList<Acorn> getMemberList(){
		ArrayList<Acorn> list = new ArrayList<>();
		
		list.add(new Acorn("t1","1234", "오메가"));
		list.add(new Acorn("t2","3334", "밀리"));
		list.add(new Acorn("t3","1233", "키드밀리"));
		
		return list;
	}
	

}
