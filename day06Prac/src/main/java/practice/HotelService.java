package practice;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class HotelService {
	
	HotelDAO dao = new HotelDAO();
	
	public JSONArray getHotelList() {
		ArrayList<Hotel> list = new ArrayList<>();
		list.add(new Hotel("h005", "power", 2));
		list.add(new Hotel("h006", "water", 4));
		list.add(new Hotel("h007", "fall", 5));
		
		JSONArray arr = new JSONArray();
		
		for(Hotel h : list) {
			JSONObject o = new JSONObject();
			o.put("hotelId", h.getHotelId());
			o.put("hotelName", h.getHotelName());
			o.put("hotelStar", h.getHotelStar());
			
			arr.put(o);
		}
		return arr;
	}
	
//	public String getHotelListStr() {
//		
//	}

}
