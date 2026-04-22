package practice;

public class Hotel {
	String hotelId;
	String hotelName;
	int hotelStar;
	
	public Hotel() {
		
	}
	public Hotel(String hotelId, String hotelName, int hotelStar) {
		
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelStar = hotelStar;
	}
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getHotelStar() {
		return hotelStar;
	}
	public void setHotelStar(int hotelStar) {
		this.hotelStar = hotelStar;
	}
	
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelStar=" + hotelStar + "]";
	}
	
	

}
