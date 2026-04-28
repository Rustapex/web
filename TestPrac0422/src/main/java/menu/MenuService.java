package menu;

import java.util.ArrayList;

public class MenuService {
	
	MenuDAO dao = new MenuDAO();
	
	public ArrayList<Menu> getMemuList(){
		return dao.findAll();
	}

}
