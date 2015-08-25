package yang.fang.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import yang.fang.domain.Project;
import yang.fang.utils.JDBCUtils;

public class ProjectDao {
	private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

	/**
	 * 查询所有部门
	 * 
	 * @param project
	 * @return
	 */
	public List<Project> list(Project project) {
		try {
			StringBuilder sql = new StringBuilder(
					"select * from s_project where 1=1 ");
			List<Object> params = new ArrayList<Object>();
			if (project.getProjectName() != null
					&& !project.getProjectName().trim().isEmpty()) {
				sql.append("and projectName like ? ");
				params.add("%" + project.getProjectName() + "%");
			}
			if (project.getLegalPerson() != null
					&& !project.getLegalPerson().trim().isEmpty()) {
				sql.append("and legalPerson like ? ");
				params.add("%" + project.getLegalPerson() + "%");
			}

			return queryRunner.query(sql.toString(),
					new BeanListHandler<Project>(Project.class),
					params.toArray());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加部门
	 * 
	 * @param project
	 */
	public void add(Project project) {
		try {
			String sql = "insert into s_project values(?,?,?,?,?,?,?)";
			queryRunner.update(sql, project.getId(), project.getProjectName(),
					project.getLegalPerson(), project.getPartner(),
					project.getFilePath(), project.getFileName(),
					project.getDescription());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(Project project) {
		try {
			String sql = "update s_project set projectName=?,legalPerson=?,partner=?,filePath=?,fileName=?,description=? where id=?";
			queryRunner.update(sql, project.getProjectName(),
					project.getLegalPerson(), project.getPartner(),
					project.getFilePath(), project.getFileName(),
					project.getDescription(), project.getId());
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
	public Project findByDid(String id) {
		try {
			String sql = "select * from s_project where id=?";
			return queryRunner.query(sql, new BeanHandler<Project>(
					Project.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void del(String id) {
		try {
			String sql = "delete from s_project where id=?";
			queryRunner.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
