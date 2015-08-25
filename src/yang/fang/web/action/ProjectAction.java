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

import yang.fang.domain.Project;
import yang.fang.service.ProjectService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class ProjectAction extends ActionSupport implements
		ModelDriven<Project> {
	private Project project = new Project();
	private ProjectService projectService = new ProjectService();

	private File attachment;// 数据
	private String attachmentFileName;// 文件名

	private String attachmentPath;// 简历保存路径

	@Override
	public Project getModel() {
		return project;
	}

	/**
	 * 查询所有项目
	 * 
	 * @return
	 */
	public String list() {
		/*
		 * 1. 使用departService查询所有数据 2. 把数据压入栈顶 3. 返回到list.jsp显示数据。
		 */
		ActionContext.getContext().getValueStack()
				.push(projectService.list(project));
		return "list";
	}

	/**
	 * 添加部门，其中包含上传简历
	 * 
	 * @throws IOException
	 */
	@InputConfig(resultName = "addUI")
	public String add() throws IOException {
		project.setId(UUID.randomUUID().toString().replace("-", ""));

		if (this.attachmentFileName != null) {
			// 下载框中的文件名称
			project.setFileName(this.attachmentFileName);
			// 实际的路径
			project.setFilePath(this.attachmentPath + "\\"
					+ UUID.randomUUID().toString().replace("-", "") + "_"
					+ this.attachmentFileName);
		}
		// 插入数据
		projectService.add(project);
		// 保存文件
		if (this.attachmentFileName != null) {
			String path = ServletActionContext.getServletContext().getRealPath(
					project.getFilePath());
			File destFile = new File(path);
			FileUtils.copyFile(attachment, destFile);
		}

		return "addSucc";
	}

	public String editUI() {
		ActionContext.getContext().getValueStack()
				.push(projectService.findByUid(project.getId()));
		return "editUI";
	}

	/**
	 * 修改部门方法
	 * 
	 * @return
	 * @throws IOException
	 */
	public String edit() throws IOException {
		if (attachment != null) {
			// 如果上传了新的简历，需要修改user对象的filename和filepath
			// 1. 删除老的简历
			// 2. 保存新的简历
			// 删除老的
			String filepath = project.getFilePath();
			File file = new File(ServletActionContext.getServletContext()
					.getRealPath(filepath));
			file.delete();
			// 保存新的
			// 下载框中的文件名称
			project.setFileName(this.attachmentFileName);
			// 实际的路径
			project.setFilePath(this.attachmentPath + "\\"
					+ UUID.randomUUID().toString().replace("-", "") + "_"
					+ this.attachmentFileName);

			// 获取目标文件的真实路径
			String path = ServletActionContext.getServletContext().getRealPath(
					project.getFilePath());
			// 创建File对象，即目标对象
			File destFile = new File(path);
			// 把源对象保存到目标对象！
			FileUtils.copyFile(attachment, destFile);
		}
		projectService.edit(project);
		return "editSucc";
	}

	/**
	 * 下载简历
	 * 
	 * @return
	 */
	public String download() {
		return "downloadSucc";
	}

	/**
	 * 查看部门信息
	 * 
	 * @return
	 */
	public String view() {
		// 查询部门信息，放入到栈顶
		ActionContext.getContext().getValueStack()
				.push(projectService.findByUid(project.getId()));
		return "view";
	}

	/**
	 * 删除部门
	 * 
	 * @return
	 */
	public String delete() {

		// 删除记录
		projectService.del(project.getId());
		return "delSucc";
	}

	/**
	 * 处理绝对路径！！！
	 * 
	 * @param attachmentFileName
	 */
	public void setAttachmentFileName(String attachmentFileName) {
		int index = attachmentFileName.lastIndexOf("\\");
		if (index != -1) {
			this.attachmentFileName = attachmentFileName.substring(index + 1);
		} else {
			this.attachmentFileName = attachmentFileName;
		}
	}

	/**
	 * 对应<action>元素的<param>元素。它表示上传文件的保存路径
	 * 
	 * @param attachmentpath
	 */
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	// 一个流
	public InputStream getInputStream() throws FileNotFoundException,
			UnsupportedEncodingException {
		String filePath = project.getFilePath();
		filePath = new String(filePath.getBytes("iso-8859-1"), "utf-8");
		String path = ServletActionContext.getServletContext().getRealPath(
				filePath);
		return new FileInputStream(path);
	}

	// 获取文件的MIME类型
	public String getMime() {
		return ServletActionContext.getServletContext().getMimeType(
				project.getFilePath());
	}

	// 获取文件名称，这需要在框中显示，所以需要处理编码问题
	public String getFilename() throws UnsupportedEncodingException {
		// 处理GET请求的中文问题
		String name = new String(project.getFileName().getBytes("ISO-8859-1"),
				"utf-8");
		// 处理在框框中显示中文的问题。
		name = new String(name.getBytes("GBK"), "ISO-8859-1");
		return name;
	}

}
