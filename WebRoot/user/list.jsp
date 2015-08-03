<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value='/css/Style.css'/>" rel="stylesheet" type="text/css" />
		<script language="javascript" src="<c:url value='/jquery/jquery-1.4.2.js'/>"></script>
		<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
		<script type="text/javascript">
			function addUser(){
				window.location.href = "<c:url value='/user/add.jsp'/>";
			}
			function test(){
				window.location.href = "<c:url value='user_list'/>";
			}
		</script>
	</HEAD>
	<body>
		<br>
		<s:form action="user_list" namespace="/" theme="simple">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>查 询 条 件</strong>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										用户姓名：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="username" size="15" cssClass="bg"></s:textfield>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										性别：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'男','女'}" name="gender" headerKey="" headerValue="--请选择--"></s:select>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										电话：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="cellphone" size="15" cssClass="bg"></s:textfield>
									</td>
								</tr>
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										学历：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'研一','研二','研三','本科','工作'}" name="education" headerKey="" headerValue="--选择学历--"/>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										是否上传简历：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select name="upload" list="#{'1':'有','2':'无'}" headerKey="" headerValue="--请选择--"/> 
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										家庭住址：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="address" size="15" cssClass="bg"></s:textfield>
									</td>
								</tr>
								<tr>
									<td width="100" height="22" align="center" bgColor="#f5fafe"
										class="ta_01">
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<font face="宋体" color="red"> &nbsp;</font>
									</td>
									<td width="100" height="22" align="center" bgColor="#f5fafe"
										class="ta_01">
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<font face="宋体" color="red"> &nbsp;</font>
									</td>
									<td align="right" bgColor="#ffffff" class="ta_01"><br><br></td>
									<td align="right" bgColor="#ffffff" class="ta_01">
										<button type="submit" id="search" name="search" value="&#26597;&#35810;" class="button_view">&#26597;&#35810;</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="reset" id="reset" name="reset" value="&#37325;&#32622;" class="button_view" onclick="test()"/>

									</td>
								</tr>
							</table>
						</td>

					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>用 户 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addUser()">&#28155;&#21152;</button>
						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										登录名
									</td>
									<td align="center" width="17%">
										用户姓名
									</td>
									<td align="center" width="8%">
										性别
									</td>
									<td align="center" width="23%">
										联系电话
									</td>
									<td width="11%" align="center">
										学历
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										查看
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<s:iterator value="top">
										<tr onmouseover="this.style.backgroundColor = '#C1FFC1'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												<s:property value="loginname"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="username"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
												<s:property value="gender"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="23%">
												<s:property value="cellphone"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												<s:property value="education"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:a action="user_editView" namespace="/">
													<s:param name="uid" value="uid" />
													<img src="<c:url value='/images/i_edit.gif'/>" border="0" style="CURSOR: hand">
												</s:a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:a action="user_view" namespace="/">
													<s:param name="uid" value="uid" />
													<img src="<c:url value='/images/button_view.gif'/>" border="0" style="CURSOR: hand">
												</s:a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:a action="user_del" namespace="/" onclick="return window.confirm('是否真的要删除该记录！');">
													<s:param name="uid" value="%{uid}" />
													<img src="<c:url value='/images/i_del.gif'/>" width="16" height="16" border="0" style="CURSOR: hand">
												</s:a>
											</td>
										</tr>
										</s:iterator>
										<tr>
											<td colSpan="8">
												<center>  
												        共&nbsp;<s:property value="intRowCount"/>&nbsp;记录    &nbsp; &nbsp;
												        第&nbsp;<s:property value="pageNow"/>&nbsp;页    
												   <s:url id="url_pre" value="user_list">     
												         	<s:param name="pageNow" value="pageNow-1"></s:param>     
												   </s:url>     
												     <s:url id="url_next" value="user_list">     
												         <s:param name="pageNow" value="pageNow+1"></s:param>     
												     </s:url>     
												     <s:iterator value="Newss" status="status">     
												        <s:url id="url" value="list.action">     
												            <s:param name="pageNow" value="pageNow"/>     
												        </s:url>     
												     </s:iterator>      
												     <s:if test="pageNow==1">  
												     	<s:a href="%{url_pre}"><font color="blue">&nbsp;第一页&nbsp;</font></s:a>  
												     </s:if>  
												     <s:else>  
												     	<s:a href="%{url_pre}"><font color="blue">&nbsp;上一页&nbsp;</font></s:a>  
												     </s:else>  
												     <s:if test="pageNow==k">  
												     	<s:a href="%{url_next}"><font color="blue">&nbsp;最后一页</font></s:a>  
												     </s:if>  
												     <s:else>  
												       <s:a href="%{url_next}"><font color="blue">下一页</font></s:a>  
												     </s:else>  
												 </center>
											</td>
										</tr>
										  
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
	</body>
</HTML>

