/**
 * @author chp
 *
 */

import java.util.List;

import cn.edu.bjtu.weibo.dao.WeiboDAO;
import cn.edu.bjtu.weibo.dao.UserDAO;
import cn.edu.bjtu.weibo.model.Weibo;


class ForwardWeiboServiceImpl implements ForwardWeiboService{

	@Override
	public int getForwardNumber(String weiboId) {
		int number = 0;
		WeiboDAO weiboDAO=new WeiboDAO();
		number = weiboDAO.getForwardNumber(weiboId);
		// TODO 
		return number;
	}

	@Override
	public List<User> getForwardUserIdList(String weiboId, int pageIndex,
			int numberPerPage) {
		List<User> user = null;
		WeiboDAO weiboDAO=new WeiboDAO();
		user = weiboDAO.getForwardList( weiboId , pageIndex , numberPerPage );
		
		// TODO 
		return user;
	}

	@Override
	public boolean forwardWeiboAction(String userId, String weiboId) {
		// TODO
		
		UserDAO userDAO = new UserDAO();//forwarder
		WeiboDAO weiboDAO=new WeiboDAO();
		boolean result1 = userDAO.insertForwardWeibo( userId, weiboId );
		
		string forwardWeiboId = userDAO.getLastWeiboId(userId);//new weibo id
	
		boolean result2 = weiboDAO.insertForwardList( weiboId, forwardWeiboId);
		if(result1&&result2)
			return true;
		return false;

	}
	
}