package web.service.face;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dto.Fran;
import web.dto.Menu;

public interface FranMenuService {

	public Map<Fran,Menu> FranMenuSelect();
	public Map<Fran,Menu> FranMemberSelect(HttpServletRequest req);
	
}
