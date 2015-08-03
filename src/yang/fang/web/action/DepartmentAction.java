package yang.fang.web.action;

import java.io.IOException;
import java.util.UUID;

import yang.fang.domain.Department;
import yang.fang.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class DepartmentAction extends ActionSupport implements
		ModelDriven<Department> {
	private Department depart = new Department();
	private DepartmentService departService = new DepartmentService();

	@Override
	public Department getModel() {
		return depart;
	}

	/**
	 * 查询所有部门
	 * 
	 * @return
	 */
	public String list() {
		/*
		 * 1. 使用departService查询所有数据 2. 把数据压入栈顶 3. 返回到list.jsp显示数据。
		 */
		ActionContext.getContext().getValueStack()
				.push(departService.list(depart));
		return "list";
	}

	/**
	 * 添加部门，其中包含上传简历
	 * 
	 * @throws IOException
	 */
	@InputConfig(resultName = "addUI")
	public String add() throws IOException {
		depart.setDid(UUID.randomUUID().toString().replace("-", ""));
		// 插入数据
		departService.add(depart);
		return "addSucc";
	}

	public String editUI() {
		ActionContext.getContext().getValueStack()
				.push(departService.findByUid(depart.getDid()));
		return "editUI";
	}

	/**
	 * 修改部门方法
	 * 
	 * @return
	 * @throws IOException
	 */
	public String edit() throws IOException {
		departService.edit(depart);
		return "editSucc";
	}

	/**
	 * 查看部门信息
	 * 
	 * @return
	 */
	public String view() {
		// 查询部门信息，放入到栈顶
		ActionContext.getContext().getValueStack()
				.push(departService.findByUid(depart.getDid()));
		return "view";
	}

	/**
	 * 删除部门
	 * 
	 * @return
	 */
	public String delete() {

		// 删除记录
		departService.del(depart.getDid());
		return "delSucc";
	}

}
