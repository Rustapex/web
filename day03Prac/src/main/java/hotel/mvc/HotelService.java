package hotel.mvc;

import java.util.ArrayList;

public class HotelService{
	
	AcornDAO dao = new AcornDAO();
	
	public ArrayList<HotelCustomer> getMemberListTmp(){		
		ArrayList<HotelCustomer>  list =  new  ArrayList<>();		
		list.add( new HotelCustomer("c003","정화연","010-3333-3333"));
		list.add( new HotelCustomer("c004","오지환","010-4444-3333"));
		list.add( new HotelCustomer("c005","차준기","010-3333-5555"));				
		return list;		
	}
	public ArrayList<HotelCustomer> getMemberListReal(){		
		ArrayList<HotelCustomer> list  =dao.selectAll();
		return list;		
	}
	
	public void registerMember(HotelCustomer hc) {		
		dao.insertMember(hc);
	}
	
	public static void main(String[] args) {
		HotelService service = new HotelService();
		ArrayList<HotelCustomer>  list=service.getMemberListReal();
		
		for( int i=0; i< list.size() ; i++) {
			 System.out.println( list.get(i));
		} 		
	}
	
	public HotelCustomer getMember(String id ) {		
		HotelCustomer hc  = dao.selectOne(id);
		return hc;
	}
	
	public void deleteMember( String customer_id) {
		dao.delete(customer_id);
	}
	
	public  void modifyMember( String customer_id, String name, String tel) {
		dao.update(customer_id, name, tel);
	}
}
