package yang.fang.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import yang.fang.domain.User;
import yang.fang.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService = new UserService();

	private File resume;// 数据
	private String resumeFileName;// 文件名

	private String resumepath;// 简历保存路径

	// 与分页相关的参数
	private int k;// 储存最大页面数
	private int pageNow = 1; // 页码数,初始为1
	private int pageSize = 10; // 页面行数
	private int intRowCount;// 总行数
	private int intPageCount;// 总页数

	@Override
	public User getModel() {
		return user;
	}

	/**
	 * 登录的请求处理方法
	 * 
	 * @return
	 */
	@InputConfig(resultName = "loginInput")
	public String login() {
		/*
		 * 1. 获取表单数据：模型驱动！ 2. 调用service方法完成登录，service方法返回一个currUser，如果为null表示失败
		 * 如果不为null，说明成功了。保存到session中。转发到loginSucc成功结果。
		 */
		User currUser = userService.login(user.getLoginname(),
				user.getLoginpass());
		if (currUser == null) {
			// 获取国际化资源信息，添加到错误中。
			this.addActionError(this.getText("loginError"));
			return "loginError";
		}
		ServletActionContext.getRequest().getSession()
				.setAttribute("user", currUser);
		return "loginSucc";
	}

	/**
	 * 查询所有员工
	 * 
	 * @return
	 */
	public String list() {
		int i = 1;// 中间变量
		intRowCount = userService.count(user);
		k = (intRowCount + pageSize - 1) / pageSize;
		intPageCount = (intRowCount + pageSize - 1) / pageSize;// 计算出总页数
		if (pageNow < 1) {
			pageNow = 1;
		}
		// if (pageNow > intPageCount)
		// pageNow = intPageCount;
		i = (pageNow - 1) * pageSize;
		/*
		 * 1. 使用userService查询所有数据 2. 把数据压入栈顶 3. 返回到list.jsp显示数据。
		 */
		ActionContext.getContext().getValueStack()
				.push(userService.list(user, i, pageSize));
		return "listSucc";
	}

	/**
	 * 添加员工，其中包含上传简历
	 * 
	 * @throws IOException
	 */
	@InputConfig(resultName = "addInput")
	public String add() throws IOException {
		/*
		 * 插入记录 1. filename和filepath
		 */
		// uid
		user.setUid(UUID.randomUUID().toString().replace("-", ""));

		if (this.resumeFileName != null) {
			// 下载框中的文件名称
			user.setFilename(this.resumeFileName);
			// 实际的路径
			user.setFilepath(this.resumepath + "\\"
					+ UUID.randomUUID().toString().replace("-", "") + "_"
					+ this.resumeFileName);
		}
		// 插入数据
		userService.add(user);
		// 保存文件
		if (this.resumeFileName != null) {
			String path = ServletActionContext.getServletContext().getRealPath(
					user.getFilepath());
			File destFile = new File(path);
			FileUtils.copyFile(resume, destFile);
		}
		return "addSucc";
	}

	/**
	 * 修改员工方法
	 * 
	 * @return
	 * @throws IOException
	 */
	public String edit() throws IOException {
		/*
		 * 修改数据库记录
		 */
		// 判断是否上传了新的简历
		if (resume != null) {
			// 如果上传了新的简历，需要修改user对象的filename和filepath
			// 1. 删除老的简历
			// 2. 保存新的简历
			// 删除老的
			String filepath = user.getFilepath();
			File file = new File(ServletActionContext.getServletContext()
					.getRealPath(filepath));
			file.delete();
			// 保存新的
			// 下载框中的文件名称
			user.setFilename(this.resumeFileName);
			// 实际的路径
			user.setFilepath(this.resumepath + "\\"
					+ UUID.randomUUID().toString().replace("-", "") + "_"
					+ this.resumeFileName);

			// 获取目标文件的真实路径
			String path = ServletActionContext.getServletContext().getRealPath(
					user.getFilepath());
			// 创建File对象，即目标对象
			File destFile = new File(path);
			// 把源对象保存到目标对象！
			FileUtils.copyFile(resume, destFile);
		}
		/*
		 * 如果没有上传新的简历，我们需要让filename和filepath保留原值。
		 * 因为表单中已经传递了老的filename和filepath，所以我们这里无需为这一问题操心了。
		 */
		// 修改数据库记录
		userService.edit(user);
		return "editSucc";
	}

	/**
	 * 处理绝对路径！！！
	 * 
	 * @param resumeFileName
	 */
	public void setResumeFileName(String resumeFileName) {
		int index = resumeFileName.lastIndexOf("\\");
		if (index != -1) {
			this.resumeFileName = resumeFileName.substring(index + 1);
		} else {
			this.resumeFileName = resumeFileName;
		}
	}

	/**
	 * 对应<action>元素的<param>元素。它表示上传文件的保存路径
	 * 
	 * @param resumepath
	 */
	public void setResumepath(String resumepath) {
		this.resumepath = resumepath;
	}

	public void setResume(File resume) {
		this.resume = resume;
	}

	/**
	 * 删除员工
	 * 
	 * @return
	 */
	public String del() {
		// 删除简历
		User currUser = userService.findByUid(user.getUid());
		new File(ServletActionContext.getServletContext().getRealPath(
				currUser.getFilepath())).delete();

		// 删除记录
		userService.del(user.getUid());
		return "delSucc";
	}

	/**
	 * 查看员工信息
	 * 
	 * @return
	 */
	public String view() {
		// 查询员工信息，放入到栈顶
		ActionContext.getContext().getValueStack()
				.push(userService.findByUid(user.getUid()));
		return "viewSucc";
	}

	// 一个流
	public InputStream getInputStream() throws FileNotFoundException,
			UnsupportedEncodingException {
		String filepath = user.getFilepath();
		filepath = new String(filepath.getBytes("iso-8859-1"), "utf-8");
		String path = ServletActionContext.getServletContext().getRealPath(
				filepath);
		return new FileInputStream(path);
	}

	// 获取文件的MIME类型
	public String getMime() {
		return ServletActionContext.getServletContext().getMimeType(
				user.getFilepath());
	}

	// 获取文件名称，这需要在框中显示，所以需要处理编码问题
	public String getFilename() throws UnsupportedEncodingException {
		// 处理GET请求的中文问题
		String name = new String(user.getFilename().getBytes("ISO-8859-1"),
				"utf-8");
		// 处理在框框中显示中文的问题。
		name = new String(name.getBytes("GBK"), "ISO-8859-1");
		return name;
	}

	public String logout() throws Exception {
		// 注销：从 session 里面删除 user
		ActionContext.getContext().getSession().remove("user");
		return "login";// 注销后，回到登录界面
	}

	/**
	 * 下载简历
	 * 
	 * @return
	 */
	public String download() {
		return "downloadSucc";
	}

	public String editView() {
		ActionContext.getContext().getValueStack()
				.push(userService.findByUid(user.getUid()));
		return "editViewSucc";
	}

	// getter and setter
	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getIntRowCount() {
		return intRowCount;
	}

	public void setIntRowCount(int intRowCount) {
		this.intRowCount = intRowCount;
	}

	public int getIntPageCount() {
		return intPageCount;
	}

	public void setIntPageCount(int intPageCount) {
		this.intPageCount = intPageCount;
	}

}
