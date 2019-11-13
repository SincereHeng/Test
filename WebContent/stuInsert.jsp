<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
//接收数据前设置编码
request.setCharacterEncoding("utf-8");
%>
<%--引入java bean --%>
<jsp:useBean id="student" class="jdbc.StudentBean" scope="request">
<%--获取输入页面表单提交的数据，并设置到StudentBean对象中 --%>
<jsp:setProperty name="student" property="*"/>
</jsp:useBean>
<jsp:useBean id="jspexdb" class="jdbc.StuDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>数据库插入操作</title>
</head>
<body>
<%
//设置操作返回值标签
int rslt=0;
request.setAttribute("operation",rslt);
try{
	//调用StuDAO中插入方法
	rslt=jspexdb.addStudent(student);
	//设置操作返回值标签
	request.setAttribute("operation", rslt);
}catch(Exception e){
%>
<%--插入不成功，返回输入页面 --%>
<jsp:forward page="stuInput.jsp"></jsp:forward>
<%
}
%>
<%--插入成功，返回查询页面 --%>
<jsp:forward page="stuSelect.jsp"></jsp:forward>>
</body>
</html>