package yang.fang.service;

import java.util.List;

import yang.fang.dao.ProjectDao;
import yang.fang.domain.Project;

public class ProjectService {
	private ProjectDao projectDao = new ProjectDao();

	/**
	 * 查询所有部门
	 * 
	 * @param Project
	 * @return
	 */
	public List<Project> list(Project project) {
		return projectDao.list(project);
	}

	/**
	 * 添加部门
	 * 
	 * @param Project
	 */
	public void add(Project project) {
		projectDao.add(project);

	}

	/**
	 * 通过id查找
	 * 
	 * @param did
	 * @return
	 */
	public Project findByUid(String did) {
		return projectDao.findByDid(did);
	}

	/**
	 * 删除指定部门
	 * 
	 * @param uid
	 */
	public void del(String did) {
		projectDao.del(did);

	}

	/**
	 * 编辑指定部门
	 * 
	 * @param Project
	 */
	public void edit(Project project) {
		projectDao.edit(project);

	}
}
