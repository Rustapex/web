package travelspot2;

public class TravelSpot {
	private String code;
	private String name;
	private String area;
	
	public TravelSpot() {
		
	}
	public TravelSpot(String code, String name, String area) {
		
		this.code = code;
		this.name = name;
		this.area = area;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Travel [code=" + code + ", name=" + name + ", area=" + area + "]";
	}
	
	
	

}
