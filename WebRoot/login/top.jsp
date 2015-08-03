<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value='/jquery/jquery-1.4.2.js'/>"></script>
		<script>
			function logout() {
				location.href = "${pageContext.request.contextPath}/user_logout";
			}
		</script>
		<style type="text/css">
BODY {
	MARGIN: 0px;
	BACKGROUND-COLOR: #ffffff
}

BODY {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TD {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TH {
	FONT-SIZE: 12px;
	COLOR: #000000
}
</style>
		<link href="<c:url value='/css/Style.css'/>" rel="stylesheet" type="text/css">
	</HEAD>
	<body>
		<table width="100%" height="70%"  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<img width="100%" src="<c:url value='/images/top_01.jpg'/>">
				</td>

				<td width="100%" background="<c:url value='/images/top_100.jpg'/>">
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30" valign="bottom" background="<c:url value='/images/mis_01.jpg'/>">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="55%" align="left">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font color="#000000"> 
								<script language="JavaScript">
									<!--
									tmpDate = new Date();
									date = tmpDate.getDate();
									month= tmpDate.getMonth() + 1 ;
									year= tmpDate.getFullYear();
									document.write(year);
									document.write("年");
									document.write(month);
									document.write("月");
									document.write(date);
									document.write("日 ");
									
									myArray=new Array(6);
									myArray[0]="星期日"
									myArray[1]="星期一"
									myArray[2]="星期二"
									myArray[3]="星期三"
									myArray[4]="星期四"
									myArray[5]="星期五"
									myArray[6]="星期六"
									weekday=tmpDate.getDay();
									if (weekday==0 | weekday==6)
									{
									document.write(myArray[weekday])
									}
									else
									{document.write(myArray[weekday])
									};
									// -->
									</script> </font>
									
							<td width="20%">		
						<iframe width="310" scrolling="no" height="25" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=40&icon=1&num=3"></iframe> 			
							</td>		
									
									
							</td>
							<td width="15%">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="16"
											background="<c:url value='/images/mis_05b.jpg'/>">
											<img
												src="<c:url value='/images/mis_05a.jpg'/>"
												width="6" height="18">
										</td>
										<td width="155" valign="bottom"
											background="<c:url value='/images/mis_05b.jpg'/>">
											用户名：
											<font color="blue">${user.username }</font>
										</td>
										<td width="10" align="right"
											background="<c:url value='/images/mis_05b.jpg'/>">
											<img src="<c:url value='/images/mis_05c.jpg'/>" width="6" height="18">
										</td>
										<td><a href="#" onclick="logout()" style="font-size:1;text-decoration:none;color:blue;">安全退出</a></td>
									</tr>
								</table>
							</td>
							<td align="right" width="5%">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</HTML>
