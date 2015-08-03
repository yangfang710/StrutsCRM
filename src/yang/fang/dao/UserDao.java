package yang.fang.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import yang.fang.domain.User;
import yang.fang.utils.JDBCUtils;

public class UserDao {
	private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

	/**
	 * 根据用户名和密码查找
	 * 
	 * @param loginname
	 * @param loginpass
	 * @return
	 */
	public User findByNameAndPass(String loginname, String loginpass) {

		try {
			String sql = "select * from s_user where loginname = ? and loginpass = ?";
			return queryRunner.query(sql, new BeanHandler<User>(User.class),
					loginname, loginpass);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询所有员工
	 * 
	 * @param user
	 * @return
	 */
	public List<User> list(User user, int i, int pageSize) {
		try {
			// 这里是组合sql语句。
			StringBuilder sql = new StringBuilder(
					"select * from s_user where 1=1 ");
			List<Object> params = new ArrayList<Object>();
			if (user.getUsername() != null
					&& !user.getUsername().trim().isEmpty()) {
				sql.append("and username like ? ");
				params.add("%" + user.getUsername() + "%");
			}
			if (user.getGender() != null && !user.getGender().trim().isEmpty()) {
				sql.append("and gender=? ");
				params.add(user.getGender());
			}
			if (user.getEducation() != null
					&& !user.getEducation().trim().isEmpty()) {
				sql.append("and education=? ");
				params.add(user.getEducation());
			}
			if (user.getAddress() != null
					&& !user.getAddress().trim().isEmpty()) {
				sql.append("and address like ? ");
				params.add("%" + user.getAddress() + "%");
			}
			if (user.getCellphone() != null
					&& !user.getCellphone().trim().isEmpty()) {
				sql.append("and cellphone like ? ");
				params.add("%" + user.getCellphone() + "%");
			}
			// 如果isUpload返回的不是null，说明用户选择“是”或“否”，为null表示用户没有选择。
			if (user.getUpload() != null && !user.getUpload().trim().isEmpty()) {
				if (user.getUpload().equals("1")) {
					sql.append("and filepath is not null ");
				} else {
					sql.append("and filepath is null ");
				}
			}
			sql.append("limit " + i + "," + pageSize);
			return queryRunner.query(sql.toString(), new BeanListHandler<User>(
					User.class), params.toArray());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加员工
	 * 
	 * @param user
	 */
	public void add(User user) {
		try {
			String sql = "insert into s_user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			queryRunner.update(sql, user.getUid(), user.getUsername(),
					user.getLoginname(), user.getLoginpass(), user.getGender(),
					user.getBirthday(), user.getFulture(), user.getAddress(),
					user.getEducation(), user.getCellphone(), user.getHobby(),
					user.getFilepath(), user.getFilename(), user.getRemark());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(User user) {
		try {
			String sql = "update s_user set username=?,loginname=?,loginpass=?,gender=?,birthday=?,fulture=?,address=?,education=?,cellphone=?,hobby=?,filepath=?,filename=?,remark=? where uid=?";
			queryRunner.update(sql, user.getUsername(), user.getLoginname(),
					user.getLoginpass(), user.getGender(), user.getBirthday(),
					user.getFulture(), user.getAddress(), user.getEducation(),
					user.getCellphone(), user.getHobby(), user.getFilepath(),
					user.getFilename(), user.getRemark(), user.getUid());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 通过uid查找用户
	 * 
	 * @param uid
	 * @return
	 */
	public User findByUid(String uid) {
		try {
			String sql = "select * from s_user where uid=?";
			return queryRunner.query(sql, new BeanHandler<User>(User.class),
					uid);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void del(String uid) {
		try {
			String sql = "delete from s_user where uid=?";
			queryRunner.update(sql, uid);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 查询总行数
	public int count(User user) {
		int intRowCount = 0;// 总行数
		try {
			// 这里是组合sql语句。
			StringBuilder sql = new StringBuilder(
					"select * from s_user where 1=1 ");
			List<Object> params = new ArrayList<Object>();
			if (user.getUsername() != null
					&& !user.getUsername().trim().isEmpty()) {
				sql.append("and username like ? ");
				params.add("%" + user.getUsername() + "%");
			}
			if (user.getGender() != null && !user.getGender().trim().isEmpty()) {
				sql.append("and gender=? ");
				params.add(user.getGender());
			}
			if (user.getEducation() != null
					&& !user.getEducation().trim().isEmpty()) {
				sql.append("and education=? ");
				params.add(user.getEducation());
			}
			if (user.getAddress() != null
					&& !user.getAddress().trim().isEmpty()) {
				sql.append("and address like ? ");
				params.add("%" + user.getAddress() + "%");
			}
			if (user.getCellphone() != null
					&& !user.getCellphone().trim().isEmpty()) {
				sql.append("and cellphone like ? ");
				params.add("%" + user.getCellphone() + "%");
			}
			// 如果isUpload返回的不是null，说明用户选择“是”或“否”，为null表示用户没有选择。
			if (user.getUpload() != null && !user.getUpload().trim().isEmpty()) {
				if (user.getUpload().equals("1")) {
					sql.append("and filepath is not null ");
				} else {
					sql.append("and filepath is null ");
				}
			}
			List<User> userList = queryRunner.query(sql.toString(),
					new BeanListHandler<User>(User.class), params.toArray());
			intRowCount = userList.size();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return intRowCount;
	}
}
