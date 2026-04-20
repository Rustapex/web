package day04Prac;

import java.util.ArrayList;

public class AcornService {

    AcornDAO dao = new AcornDAO();

    // 전체 조회
    public ArrayList<Acorn> getMembers() {
        return dao.SelectAll();
    }

    // 한 명 조회
    public Acorn getMember(String id) {
        return dao.selectOne(id);
    }

    // 등록
    public int registerMember(Acorn acorn) {
        return dao.insertMember(acorn);
    }

    // 수정
    public int modifyMember(Acorn acorn) {
        return dao.updateMember(acorn);
    }

    // 삭제
    public int removeMember(String id) {
        Acorn acorn = new Acorn();
        acorn.setId(id);
        return dao.deleteMember(acorn);
    }
}