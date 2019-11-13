package jdbc;
import java.sql.*;
import java.util.ArrayList;
public class StuDAO {
	//定义私有变量保存连接对象
	private Connection con;
	//查询所有Student的方法
	public ArrayList<StudentBean> getAllStudent() throws Exception{
		//获取连接对象
		con=DbConnection.getConnection();
		//创建语句(Statement)对象
		Statement stm=con.createStatement();
		//执行Sql语句，返回结果集（ResultSet对象）
		ResultSet rs=stm.executeQuery("select * from student");
		ArrayList<StudentBean> data=new ArrayList<StudentBean>();
		while(rs.next()) {
			StudentBean item=new StudentBean();
			item.setId(rs.getInt("id"));
			item.setName(rs.getString("name"));
			item.setGender(rs.getString("sex"));
			item.setGrade(rs.getString("class"));
			item.setChinese(rs.getFloat("chinese"));
			item.setMaths(rs.getFloat("maths"));
			item.setPhysics(rs.getFloat("physics"));
			item.setChemistry(rs.getFloat("chemistry"));
			//item.setDate(rs.getDate("date"));
			data.add(item);
		}
		rs.close();
		stm.close();
		con.close();
		return data;
	}
	//通过Id查询student，返回StudentBean对象
	public StudentBean getStudentById(String stuId) throws Exception {
		con=DbConnection.getConnection();
		Statement stmt=con.createStatement();
		String strSql="select * from student where id="+stuId;
		ResultSet rs=stmt.executeQuery(strSql);
		//以下为调用数据库中存储过程
		/*CallableStatement cstm=con.prepareCall("{call getStudentById2(?,?)}");
		//设置in参数
		cstm.setInt(1, Integer.parseInt(stuId));
		//注册out参数
		cstm.registerOutParameter(2, java.sql.Types.VARCHAR);
		ResultSet rs=cstm.executeQuery();
		//获取out参数的返回值，并显示
		String serversion=cstm.getString(2);
		System.out.println("数据库服务器的版本为:"+serversion);*/
		
		
		
		StudentBean item=null;
		while(rs.next()) {
			item=new StudentBean();
			item.setId(rs.getInt("id"));
			item.setName(rs.getString("name"));
			item.setGender(rs.getString("sex"));
			item.setGrade(rs.getString("class"));
			item.setChinese(rs.getFloat("chinese"));
			item.setMaths(rs.getFloat("maths"));
			item.setPhysics(rs.getFloat("physics"));
			item.setChemistry(rs.getFloat("chemistry"));
		}
		rs.close();
		stmt.close();
		//cstm.close();
		con.close();
		return item;
	}
	//插入一名学生
	//传递一个StudentBean对象的参数
	public int addStudent(StudentBean student) throws Exception{
		con=DbConnection.getConnection();
		/*Statement stmt=con.createStatement();
		String sqlStr="insert into student(name,sex,class,chinese,maths,physics,chemistry) values ('"+student.getName()+"','"+student.getGender()+"','"+student.getGrade()+"',"+student.getChinese()+","+student.getMaths()+","+student.getPhysics()+","+student.getChemistry()+")";
		int rslt=stmt.executeUpdate(sqlStr);*/
		//PreparedStatement对象实现SQL代码
		String sqlStr1="insert into student(name,sex,class,chinese,maths,physics,chemistry) values (?,?,?,?,?,?,?)";
		PreparedStatement pstm=con.prepareStatement(sqlStr1);
		pstm.setString(1, student.getName());
		pstm.setString(2, student.getGender());
		pstm.setString(3, student.getGrade());
		pstm.setFloat(4, student.getChinese());
		pstm.setFloat(5, student.getMaths());
		pstm.setFloat(6, student.getPhysics());
		pstm.setFloat(7, student.getChemistry());
		int rslt=pstm.executeUpdate();
		pstm.close();
		//stmt.close();
		con.close();
		return rslt;
	}
	//修改学生信息，传入一个StudentBean对象参数
	public int modifyStudent(StudentBean student) throws Exception{
		con=DbConnection.getConnection();
		Statement stmt=con.createStatement();
		String sqlStr="update student set name='"+student.getName()+"',sex='"+student.getGender()+"',class='"+student.getGrade()+"',chinese="+student.getChinese()+",maths="+student.getMaths()+",physics="+student.getPhysics()+",chemistry="+student.getChemistry()+" where id="+student.getId();
		int rslt=stmt.executeUpdate(sqlStr);
		/*String sqlStr1="update student set name=?,sex=?,class=?,chinese=?,maths=?,physics=?,chemistry=? where id=?";
		PreparedStatement pstm=con.prepareStatement(sqlStr1);
		pstm.setString(1, student.getName());
		pstm.setString(2, student.getGender());
		pstm.setString(3, student.getGrade());
		pstm.setFloat(4, student.getChinese());
		pstm.setFloat(5, student.getMaths());
		pstm.setFloat(6, student.getPhysics());
		pstm.setFloat(7, student.getChemistry());
		pstm.setInt(8, student.getId());
		int rslt=pstm.executeUpdate();
		pstm.close();*/
		stmt.close();
		con.close();
		return rslt;
	}
	//删除学生，传递学生id为参数
	public int deleteStudent(String stuId) throws Exception{
		con=DbConnection.getConnection();
		Statement stmt=con.createStatement();
		String sqlStr="delete from student where id="+stuId;
		int rslt=stmt.executeUpdate(sqlStr);
		stmt.close();
		con.close();
		return rslt;
	}
}
