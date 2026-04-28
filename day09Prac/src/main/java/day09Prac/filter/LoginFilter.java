package day09Prac.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*  1. Filter javax.servlet 인터페이스 상속받기
 *  2. doFilter override 하기
 *  3. session 에서 로그인 정보 확인하기
 *  4. 필터로 등록하기 (mapping 정보 => 확장자 기반)
 *  5. 
 * 
 * */

@WebFilter("*.do")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		ServletRequest(부모) -> HttpServletRequest (자식) [ 실제 객체]
		
//		다운캐스팅 (servletRequest -> HttpServletRequest)
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp =(HttpServletResponse) response;
		
//		세션 가져오기 
		HttpSession session = req.getSession(false);
		String id = (session != null) ? (String) session.getAttribute("id") : null;
		
//		세션에 저장된 아이디 정보 가져오기
		if( id !=null) {
//			정보 있으면 => 정상적 흐름 보내기
			chain.doFilter(req, resp);
			return;
		}

//		없으면 => 로그인 할 수 있도록 sendRedirect
		String path = req.getContextPath();
		resp.sendRedirect(path + "/login");
	}

}
