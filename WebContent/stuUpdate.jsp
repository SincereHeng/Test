<%@ page import="jdbc.StudentBean" language="java" contentType="text/html; charset=utf-8"%>
<%--引入java bean --%>
<jsp:useBean id="jspexdb" class="jdbc.StuDAO"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function inputval(){
	if(isNaN(parseFloat(document.getElementById("chinese").value))||isNaN(parseFloat(document.getElementById("maths").value))||isNaN(parseFloat(document.getElementById("physics").value))||isNaN(parseFloat(document.getElementById("chemistry").value))){
		alert("数据输入不合法，成绩必须为数值！");
		return false;
	}
	return true;
}
</script>
<%
//获取前一页面传递的Id值
String stuid=request.getParameter("stuId");
StudentBean student=null;
try{
	//调用StuDAO中方法，获取对应的Id记录
	student=jspexdb.getStudentById(stuid);
}catch(Exception e){
	//设置操作返回值标签
	request.setAttribute("operation",0);
%>
<jsp:forward page="stuSelect.jsp"></jsp:forward>
<%	
}
%>
<table align="center" cellpadding="4" cellspacing="4">
<tr>
<td><h2>学生信息输入</h2></td>
</tr>
</table>
<form action="stuUpdate_do.jsp" method="post" onsubmit="return inputval()">
<input type="hidden" name="id" id="id" value="<%=student.getId()%>"/>
<table align="center" width="260" bgcolor="lightblue" cellpadding="4" cellspacing="0">
<tr>
<td align="right">姓名：</td>
<td align="left"><input type="text" name="name" id="name" value=<%=student.getName() %>></td>
</tr>
<tr>
<td align="right">姓别：</td>
<td align="left"><input type="text" name="gender" id="gender" value=<%=student.getGender() %>></td>
</tr>
<tr>
<td align="right">班级：</td>
<td align="left"><input type="text" name="grade" id="grade" value=<%=student.getGrade() %>></td>
</tr>
<tr>
<td align="right">语文：</td>
<td align="left"><input type="text" name="chinese" id="chinese" value=<%=student.getChinese() %>></td>
</tr>
<tr>
<td align="right">数学：</td>
<td align="left"><input type="text" name="maths" id="maths" value=<%=student.getMaths() %>></td>
</tr>
<tr>
<td align="right">物理：</td>
<td align="left"><input type="text" name="physics" id="physics" value=<%=student.getPhysics() %>></td>
</tr>
<tr>
<td align="right">化学：</td>
<td align="left"><input type="text" name="chemistry" id="chemistry" value=<%=student.getChemistry() %>></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="修改">&nbsp;&nbsp;
<input type="reset" value="重置"></td>
</tr>
</table>
</form>
<%
if(request.getAttribute("operation")!=null&&((int)request.getAttribute("operation"))==0){
%>
<%--更新不成功，显示出错警告 --%>
<script type="text/javascript">
alert("更新记录出错！请检查数据输入是符合法。");
</script>
<%} %>
</body>
</html>