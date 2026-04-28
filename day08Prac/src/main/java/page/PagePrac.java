package page;

public class PagePrac {
	public static void main(String[] args) {
		
		int pageSize = 4;
		int grpSize =5;
		int totRecords = 37;
		int currentPage = 6;
		
//		구해야 한 값
		int totalPage;		// 전체 페이지 수
		int currentGrp; 	// 현재 그룹
		int grpStartPage;	// 현재 그룹 시작 페이지
		int grpEndPage;		// 현재 그룹 끝 페이지
		
//		전체 페이지 수 
		int remain = totRecords % pageSize;
		
		if(remain ==0) {
			totalPage = totRecords / pageSize;
		} else {
			totalPage = totRecords / pageSize + 1;
		}
		
		
//		현재 페이지에 대한 현재 그룹 구하기
		int remain2 = currentPage % pageSize;
		
		if(remain2 ==0) {
			currentGrp = currentPage / pageSize;
		} else {
			currentGrp = currentPage / pageSize +1;
		}
		
		
//		현재 그룹의 시작 페이지
		grpStartPage = (currentGrp -1) * grpSize +1;
		
//		현재 그룹의 끝 페이지
		
		grpEndPage = Math.min(currentGrp * grpSize, totalPage);
		
		
//		페이징 정보
		System.out.printf("전체 페이지 수  : %d, 현재 그룹 : %d%n현재 그룹 시작페이지 : %d , 현재 그룹 끝 페이지 : %d%n현재 페이지 : %d%n", 
				totalPage,currentGrp,grpStartPage,grpEndPage, currentPage);
		
		
		
		for(int i=grpStartPage; i<=grpEndPage; i++) {
			System.out.printf("[%d]", i);
		}
		
	}

}
