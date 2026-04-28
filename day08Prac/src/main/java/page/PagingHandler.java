package page;

public class PagingHandler {
	
	
	int pageSize;
	int grpSize;
	int totRecords;
	int currentPage; 
	
	
	
	public PagingHandler(int pageSize, int grpSize, int totRecords, int currentPage) {
		this.pageSize = pageSize;
		this.grpSize = grpSize;
		this.totRecords = totRecords;
		this.currentPage = currentPage;
		calcPaging();
	}
	
	private void calcPaging() {
//		전체 페이지 수 
		totalPage = (int)Math.ceil((double)totRecords / pageSize);
//		현재 페이지에 대한 현재 그룹 구하기
	    currentGrp = (int)Math.ceil((double)currentPage / grpSize);
//		현재 그룹의 시작 페이지
	    grpStartPage = (currentGrp - 1) * grpSize + 1;

//		현재 그룹의 끝 페이지
	    grpEndPage = Math.min(currentGrp * grpSize, totalPage);
		
	}


	public int getPageSize() {
		return pageSize;
	}

	public int getGrpSize() {
		return grpSize;
	}

	public int getTotRecords() {
		return totRecords;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getCurrentGrp() {
		return currentGrp;
	}

	public int getGrpStartPage() {
		return grpStartPage;
	}

	public int getGrpEndPage() {
		return grpEndPage;
	}


	//	구해야 한 값
	int totalPage;		// 전체 페이지 수
	int currentGrp; 	// 현재 그룹
	int grpStartPage;	// 현재 그룹 시작 페이지
	int grpEndPage;		// 현재 그룹 끝 페이지
	
	
	public static void main(String[] args) {
		PagingHandler handler = new PagingHandler(10,5,113,6);
		
		System.out.printf("전체  페이지 수 : %d%n", handler.getTotalPage());
		System.out.printf("현재 그룹 : %d%n", handler.getCurrentGrp());
		System.out.printf("전체  페이지 수 : %d%n", handler.getGrpStartPage());
		System.out.printf("전체  페이지 수 : %d%n", handler.getGrpEndPage());
		
		for(int i=handler.getGrpStartPage(); i<=handler.getGrpEndPage(); i++) {
			System.out.printf("[%d]", i);
		}
	
	}

}
