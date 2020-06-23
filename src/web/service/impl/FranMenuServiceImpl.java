package web.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.FranDao;
import web.dao.impl.FranDaoImpl;
import web.dto.Fran;
import web.dto.Menu;
import web.service.face.FranMenuService;

public class FranMenuServiceImpl implements FranMenuService{
private FranDao franDao = new FranDaoImpl();

	@Override
	public Map<Fran, Menu> FranMenuSelect() {
	
		
		return franDao.SelectFranMenu();
	}

	@Override
	public Map<Fran, Menu> FranMemberSelect(HttpServletRequest req) {
		Fran fran = new Fran();
		fran.setFranName(req.getParameter("search"));
		
		return franDao.SelectFranMember(fran);
	}

}
