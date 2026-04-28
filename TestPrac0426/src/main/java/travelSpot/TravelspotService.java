package travelSpot;

import java.util.ArrayList;

public class TravelspotService {
	TravelspotDAO dao = new TravelspotDAO();
	
	public ArrayList<Travelspot> getTravelspot(){
		return dao.findAll();
	}

}
