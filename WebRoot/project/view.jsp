<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="<c:url value='/css/Style.css'/>" type="text/css" rel="stylesheet">
		<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
		<script language="javascript" src="<c:url value='/js/check.js'/>"></script>
		<script language="javascript" src="<c:url value='/js/address.js'/>"></script>
	</HEAD>
	<script type="text/javascript">

	</script>
	<body>
	    <s:form action="project_edit" namespace="/" enctype="multipart/form-data" theme="simple">
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>查看项目</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						项目名称：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textfield name="projectName" value="%{projectName}" cssClass="bg"></s:textfield>
					</td>
				</tr>
				<tr >
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">负责人：</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
					    <s:textfield name="legalPerson" value="%{legalPerson}" cssClass="bg"></s:textfield>
					</td>
				</tr>
				<tr >
					<td align="center" bgColor="#f5fafe" class="ta_01">
						开发人员：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield id="partner" name="partner" value="%{partner}" cssClass="bg"></s:textfield>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						项目资料：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:a action="project_download" namespace="/" cssClass="cl_01">
							<s:param name="filePath" value="filePath" />
							<s:param name="fileName" value="fileName" />
							<s:property value="fileName"/>
						</s:a>
					</td>
				</tr>
				<TR>
					<TD class="ta_01" align="center" bgColor="#f5fafe">
						描述：
					</TD>
					<TD class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textarea name="description"  value="%{description}" cols="30" rows="3" cssStyle="WIDTH: 96%" />
					</TD>
				</TR>
				<TR>
					<td align="center" colSpan="4" class="sep1">
						<img src="<c:url value='/images/shim.gif'/>">
					</td>
				</TR>


				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" name="submit" value="&#30830;&#23450;" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="&#37325;&#32622;" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</HTML>