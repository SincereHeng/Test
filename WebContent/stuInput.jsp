<%@ page language="java" contentType="text/html; charset=utf-8"%>
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
<table align="center" cellpadding="4" cellspacing="4">
<tr>
<td><h2>学生信息输入</h2></td>
</tr>
</table>
<form action="stuInsert.jsp" method="post" onsubmit="return inputval()">
<table align="center" width="260" bgcolor="lightblue" cellpadding="4" cellspacing="0">
<tr>
<td align="right">姓名：</td>
<td align="left"><input type="text" name="name" id="name"></td>
</tr>
<tr>
<td align="right">性别：</td>
<td align="left"><input type="text" name="gender" id="gender"></td>
</tr>
<tr>
<td align="right">班级：</td>
<td align="left"><input type="text" name="grade" id="grade"></td>
</tr>
<tr>
<td align="right">语文：</td>
<td align="left"><input type="text" name="chinese" id="chinese"></td>
</tr>
<tr>
<td align="right">数学：</td>
<td align="left"><input type="text" name="maths" id="maths"></td>
</tr>
<tr>
<td align="right">物理：</td>
<td align="left"><input type="text" name="physics" id="physics"></td>
</tr>
<tr>
<td align="right">化学：</td>
<td align="left"><input type="text" name="chemistry" id="chemistry"></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="添加">&nbsp;&nbsp;
<input type="reset" value="重置"></td>
</tr>
</table>
</form>
</body>
</html>