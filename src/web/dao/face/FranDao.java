package web.dao.face;

import java.util.Map;

import web.dto.Fran;
import web.dto.Menu;
import web.dto.Report;
import web.dto.User;
import web.util.Paging;

public interface FranDao {

	public Map<Fran,Menu> SelectFranMenu();
	public Map<Fran,Menu> SelectFranMember(Fran fran);
	
	//--------------------------------------------------------------------
	
	public int selectCntFran();
	public Map<Fran, String> selectFran(Paging paging);
	
}
