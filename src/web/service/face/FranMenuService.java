package web.service.face;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dto.Fran;
import web.dto.Menu;
import web.dto.Report;
import web.dto.User;
import web.util.Paging;

public interface FranMenuService {

	public Map<Fran,Menu> FranMenuSelect();
	public Map<Fran,Menu> FranMemberSelect(HttpServletRequest req);
	
	//--------------------------------------------------------------------
	
	public Paging getPagingReport(HttpServletRequest req);
	public Map<Fran, String> viewFran(Paging paging);
	
}
