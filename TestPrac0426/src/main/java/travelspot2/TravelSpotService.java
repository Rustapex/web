package travelspot2;

import java.util.ArrayList;

public class TravelSpotService {
	
	TravelSpotDAO dao = new TravelSpotDAO();
	
	public ArrayList<TravelSpot> getTravelSpotList(){
		return dao.findAll();
	}

}
