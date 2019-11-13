<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="student" class="jdbc.StudentBean" scope="request">
<jsp:setProperty property="*" name="student"/>
</jsp:useBean>
<<jsp:useBean id="jspexdb" class="jdbc.StuDAO"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
//如果StudentBean对象不为空，则更新指定记录
if(student!=null){
	try{
		jspexdb.modifyStudent(student);
		request.setAttribute("operation",2);
	}catch(Exception e){
		request.setAttribute("operation",0);
%>
<%--更新不成功，返回输出页面 --%>
<jsp:forward page="stuUpdate.jsp"></jsp:forward>
<%
	}
	}
%>
<%--操作结束，返回查询页面 --%>
<jsp:forward page="stuSelect.jsp"></jsp:forward>
</body>
</html>