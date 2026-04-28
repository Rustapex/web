package notice;

import java.util.ArrayList;

public class NoticeService {
	
	NoticeDAO dao = new NoticeDAO();
	
	public ArrayList<Notice> getNoticeList() {
		return dao.selectRecentFive();
	}

}
