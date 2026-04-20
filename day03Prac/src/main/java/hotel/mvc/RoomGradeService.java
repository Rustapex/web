package hotel.mvc;

import java.util.ArrayList;

public class RoomGradeService {
	
	RoomGradeDAO dao = new RoomGradeDAO();
	
//	전체조회
	public ArrayList<RoomGrade> getRoomGradeList(){
		return dao.selectAll();
	}
	
//	하나 조회
	public RoomGrade getRoomGrade(String roomgradeNum) {
		return dao.selectOne(roomgradeNum);
	}
	
//	등록하기
	public int registerRoomGrade(RoomGrade roomGrade) {
		return dao.insert(roomGrade);
	}
	
//	수정하기
	public int modifyRoomGrade(RoomGrade roomGrade) {
		return dao.update(roomGrade);
	}
	
//	삭제하기
	public int removeRoomGrade(String roomgradeNum) {
		return dao.delete(roomgradeNum);
	}

}
