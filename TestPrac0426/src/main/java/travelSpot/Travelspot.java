package travelSpot;

public class Travelspot {
	String spotId;
	String spotName;
	String region;
	
	public Travelspot() {
		
	}
	public Travelspot(String spotId, String spotName, String region) {
	
	this.spotId = spotId;
	this.spotName = spotName;
	this.region = region;
	}

	public String getSpotId() {
		return spotId;
	}

	public void setSpotId(String spotId) {
		this.spotId = spotId;
	}

	public String getSpotName() {
		return spotName;
	}

	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	

	@Override
	public String toString() {
		return "Travelspot [spotId=" + spotId + ", spotName=" + spotName + ", region=" + region + "]";
	}

	

	

	
	
	

}
