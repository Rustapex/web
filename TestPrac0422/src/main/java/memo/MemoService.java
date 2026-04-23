package memo;

import java.util.ArrayList;

public class MemoService {
	
	MemoDAO dao = new MemoDAO();
	
	public ArrayList<Memo> getMemoList(){
		return dao.findAll();
	}

}
