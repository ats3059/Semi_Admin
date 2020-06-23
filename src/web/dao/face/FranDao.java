package web.dao.face;

import java.util.Map;

import web.dto.Fran;
import web.dto.Menu;

public interface FranDao {

	public Map<Fran,Menu> SelectFranMenu();
	public Map<Fran,Menu> SelectFranMember(Fran fran);
	
}
