package web.controller.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Fran;
import web.dto.Menu;
import web.service.face.FranMenuService;
import web.service.impl.FranMenuServiceImpl;

@WebServlet("/web/franman/search")
public class Web_franManagementSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FranMenuService franmenuService = new FranMenuServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Map<Fran,Menu> map = franmenuService.FranMemberSelect(request);
		
		System.out.println(request.getParameter("franno"));
		
		
		request.getRequestDispatcher("/WEB-INF/views/web_fran_management_search.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
