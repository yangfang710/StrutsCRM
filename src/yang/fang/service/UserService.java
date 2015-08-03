package yang.fang.service;

import java.util.List;

import yang.fang.dao.UserDao;
import yang.fang.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();

	/**
	 * 实现用户登录
	 * 
	 * @param loginname
	 * @param loginpass
	 * @return
	 */
	public User login(String loginname, String loginpass) {
		return userDao.findByNameAndPass(loginname, loginpass);
	}

	/**
	 * 查询所有员工
	 * 
	 * @param user
	 * @param pageSize
	 * @param i
	 * @return
	 */
	public List<User> list(User user, int i, int pageSize) {
		return userDao.list(user, i, pageSize);
	}

	/**
	 * 添加员工
	 * 
	 * @param user
	 */
	public void add(User user) {
		userDao.add(user);

	}

	/**
	 * 通过id查找
	 * 
	 * @param uid
	 * @return
	 */
	public User findByUid(String uid) {
		return userDao.findByUid(uid);
	}

	/**
	 * 删除指定用户
	 * 
	 * @param uid
	 */
	public void del(String uid) {
		userDao.del(uid);

	}

	/**
	 * 编辑指定用户
	 * 
	 * @param user
	 */
	public void edit(User user) {
		userDao.edit(user);

	}

	/**
	 * 获取总记录数
	 * 
	 * @param user
	 * 
	 * @return
	 */
	public int count(User user) {

		return userDao.count(user);
	}
}
