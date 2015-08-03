package yang.fang.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import yang.fang.domain.Department;
import yang.fang.utils.JDBCUtils;

public class DepartmentDao {
	private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

	/**
	 * 查询所有部门
	 * 
	 * @param department
	 * @return
	 */
	public List<Department> list(Department department) {
		try {
			StringBuilder sql = new StringBuilder(
					"select * from s_department where 1=1 ");
			List<Object> params = new ArrayList<Object>();
			if (department.getDeptName() != null
					&& !department.getDeptName().trim().isEmpty()) {
				sql.append("and deptName like ? ");
				params.add("%" + department.getDeptName() + "%");
			}
			if (department.getAddress() != null
					&& !department.getAddress().trim().isEmpty()) {
				sql.append("and address=? ");
				params.add(department.getAddress());
			}

			return queryRunner.query(sql.toString(),
					new BeanListHandler<Department>(Department.class),
					params.toArray());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加部门
	 * 
	 * @param department
	 */
	public void add(Department department) {
		try {
			String sql = "insert into s_department values(?,?,?,?)";
			queryRunner.update(sql, department.getDid(),
					department.getDeptName(), department.getAddress(),
					department.getDescription());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(Department department) {
		try {
			String sql = "update s_department set deptName=?,address=?,description=? where did=?";
			queryRunner.update(sql, department.getDeptName(),
					department.getAddress(), department.getDescription(),
					department.getDid());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 通过did查找部门
	 * 
	 * @param did
	 * @return
	 */
	public Department findByDid(String did) {
		try {
			String sql = "select * from s_department where did=?";
			return queryRunner.query(sql, new BeanHandler<Department>(
					Department.class), did);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void del(String did) {
		try {
			String sql = "delete from s_department where did=?";
			queryRunner.update(sql, did);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
