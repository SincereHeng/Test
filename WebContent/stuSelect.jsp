<%@ page import="java.util.*,jdbc.StudentBean" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="studentDao" class="jdbc.StuDAO" scope="page"/>
<body>
<br/>
<table width="680" cellpadding="0" cellspacing="0" align="center">
<caption>学生信息管理</caption>
<tr>
<td align="right"><a href=stuInput.jsp>增加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
<td height="24"><hr/></td>
</tr>
</table>
<table width="680" border="1" align="center" cellpadding="4" cellspacing="0" bordercolor="d3effc">
<tr align="center" bgcolor="#d3effc">
<td>学生姓名</td>
<td>性别</td>
<td>班级</td>
<td>语文</td>
<td>数学</td>
<td>物理</td>
<td>化学</td>
<!--<td>时间</td>  -->
<td>更改</td>
<td>删除</td>
</tr>
<%
ArrayList<StudentBean> student=studentDao.getAllStudent();
for(StudentBean temp:student){
	out.println("<tr bordercolor=#990066>");
	out.println("<td align='center'>"+temp.getName()+"</td>");
	out.println("<td align='center'>"+temp.getGender()+"</td>");
	out.println("<td align='center'>"+temp.getGrade()+"</td>");
	out.println("<td align='right'>"+temp.getChinese()+"</td>");
	out.println("<td align='right'>"+temp.getMaths()+"</td>");
	out.println("<td align='right'>"+temp.getPhysics()+"</td>");
	out.println("<td align='center'>"+temp.getChemistry()+"</td>");
	//out.println("<td align='center'>"+temp.getDate()+"</td>");
	out.println("<td align='center'><a href='stuUpdate.jsp?stuId="+temp.getId()+"'>修改</a></td>");
	out.println("<td align='center'><a href='stuDelete_do.jsp?stuId="+temp.getId()+"' onclick='return confirm(\"确定要删除本记录吗？\")'>删除</a></td>");
	out.println("</tr>");
}
%>
</table>
<%--获取操作返回后传回的参数 --%>
<%
String infostr="";
if(request.getAttribute("operation")!=null){
	if((int)request.getAttribute("operation")==0){
		infostr="数据库操作不成功！";
	}else if((int)request.getAttribute("operation")==1){
		infostr="成功添加一条记录！";
	}else if((int)request.getAttribute("operation")==2){
		infostr="成功修改一条记录！";
	}else if((int)request.getAttribute("operation")==3){
		infostr="成功删除一条记录！";
	}
%>
<%--显示数据库操作信息 --%>
<script type="text/javascript">
alert("<%=infostr%>");
</script>
<%
}
%>
</body>
</html>