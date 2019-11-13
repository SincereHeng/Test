<%@ page language="java" contentType="text/html; charset=utf-8"%>
<jsp:useBean id="jspexdb" class="jdbc.StuDAO"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String stuid=request.getParameter("stuId");
//如果id不为空，则删除指定记录
if(stuid!=null&&!stuid.equals("")){
	try{
		jspexdb.deleteStudent(stuid);
		request.setAttribute("operation",3);
	}catch(Exception e){
		request.setAttribute("operation",0);
	}
}
%>
<%--操作结束，返回查询页面 --%>
<jsp:forward page="stuSelect.jsp"></jsp:forward>
</body>
</html>