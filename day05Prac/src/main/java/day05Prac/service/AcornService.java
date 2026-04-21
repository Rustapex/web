package day05Prac.service;

import java.util.ArrayList;

import day05Prac.dao.AcornDAO;
import day05Prac.dto.Acorn;

public class AcornService {
	
	AcornDAO dao = new AcornDAO();
	
//	전체조회
	public ArrayList<Acorn> getMembers(){
		return dao.selectAll();
	}
	
//	등록하기
	public int registerMember(Acorn acorn) {
		return dao.insert(acorn);
	}
	
//	하나 조회
	public Acorn getAcorn(String id) {
		return dao.findById(id);
	}
	
//	수정하기
	public int modifyAcorn(Acorn acorn) {
		return dao.update(acorn);
	}
	
//	삭제하기
	public int deleteAcorn(String id) {
		return dao.delete(id);
	}
	

}
