package hotel.mvc;

public class RoomGrade {
	String roomgrade_num;
	String room_name;
	int price;
	String hotel_id;
	
	public RoomGrade() {
	}

	public RoomGrade(String roomgrade_num, String room_name, int price, String hotel_id) {
		this.roomgrade_num = roomgrade_num;
		this.room_name = room_name;
		this.price = price;
		this.hotel_id = hotel_id;
	}

	public String getRoomgrade_num() {
		return roomgrade_num;
	}

	public void setRoomgrade_num(String roomgrade_num) {
		this.roomgrade_num = roomgrade_num;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	@Override
	public String toString() {
		return "RoomGrade [roomgrade_num=" + roomgrade_num + ", room_name=" + room_name + ", price=" + price
				+ ", hotel_id=" + hotel_id + "]";
	}
	
	

}
