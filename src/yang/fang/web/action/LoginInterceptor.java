package yang.fang.web.action;

import yang.fang.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user == null) {
			// 如果session中不存在user，那么向action中添加错误信息
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError("您还没有登录！");
			return "login";
		}
		return invocation.invoke();// 放行
	}

}
