package day06Prac;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/foodReg")
public class FoodRegServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
				req.setCharacterEncoding("utf-8");
				BufferedReader  br  = req.getReader();
				
				StringBuilder sb = new StringBuilder();
				
				String line;
				while( (line= br.readLine()) != null) {
					sb.append(line);
				}
				
				br.close();
				
				System.out.println( sb.toString());
				
				resp.getWriter().print("1");
				
				
				JSONObject jsonBody = new JSONObject(sb.toString());
				String name = jsonBody.getString("name");
				int price = jsonBody.getInt("price");
				
				Food food = new Food(name, price);
				System.out.println(food);
				
				// service - dao ->
	}
}
