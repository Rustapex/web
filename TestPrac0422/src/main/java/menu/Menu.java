package menu;

public class Menu {
	private String menuId;
	private String menuName;
	
	public Menu() {
		
	}

	public Menu(String menuId, String menuName) {
		this.menuId = menuId;
		this.menuName = menuName;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + "]";
	}
	
}
