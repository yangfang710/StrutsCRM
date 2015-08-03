package yang.fang.service;

import java.util.List;

import yang.fang.dao.DepartmentDao;
import yang.fang.domain.Department;

public class DepartmentService {
	private DepartmentDao departmentDao = new DepartmentDao();

	/**
	 * 查询所有部门
	 * 
	 * @param department
	 * @return
	 */
	public List<Department> list(Department department) {
		return departmentDao.list(department);
	}

	/**
	 * 添加部门
	 * 
	 * @param department
	 */
	public void add(Department department) {
		departmentDao.add(department);

	}

	/**
	 * 通过id查找
	 * 
	 * @param did
	 * @return
	 */
	public Department findByUid(String did) {
		return departmentDao.findByDid(did);
	}

	/**
	 * 删除指定部门
	 * 
	 * @param uid
	 */
	public void del(String did) {
		departmentDao.del(did);

	}

	/**
	 * 编辑指定部门
	 * 
	 * @param department
	 */
	public void edit(Department department) {
		departmentDao.edit(department);

	}
}
