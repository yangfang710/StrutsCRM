<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="<c:url value='/css/left.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="<c:url value='/css/dtree.css'/>" type="text/css" />
	<script type="text/javascript" src="<c:url value='/js/dtree.js'/>"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add(0,-1,'系统菜单树');
		d.add(2,0,'员工管理','<c:url value="/login/welcome.jsp"/>','','mainFrame');
		d.add(3,0,'部门管理','<c:url value="/login/welcome.jsp"/>','','mainFrame');
		//子目录添加
		d.add(4,2,'用户管理','<s:url action="user_list" namespace="/"/>','','mainFrame');
		d.add(5,3,'部门管理','<s:url action="department_list" namespace="/"/>','','mainFrame');

		
		document.write(d);
		//-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
