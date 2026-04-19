package hotel.mvc;

public class HotelCustomer {
	String customer_id;
	String name;
	String tel;
	
	public HotelCustomer() {
		
	}

	public HotelCustomer(String customer_id, String name, String tel) {
		
		this.customer_id = customer_id;
		this.name = name;
		this.tel = tel;
	}



	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "HotelCustomer [customer_id=" + customer_id + ", name=" + name + ", tel=" + tel + "]";
	}
	
	
	

}
