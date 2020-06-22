package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fran")
public class FranMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 첫화면(로그인됬을경우)에는 등록된 프랜차이즈 게시물들을 보여준다
		req.getRequestDispatcher("/WEB-INF/views/fran_main.jsp").forward(req, resp);
	
	}
	
	
}
