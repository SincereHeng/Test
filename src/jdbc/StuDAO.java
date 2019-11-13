package jdbc;
import java.sql.*;
import java.util.ArrayList;
public class StuDAO {
	//����˽�б����������Ӷ���
	private Connection con;
	//��ѯ����Student�ķ���
	public ArrayList<StudentBean> getAllStudent() throws Exception{
		//��ȡ���Ӷ���
		con=DbConnection.getConnection();
		//�������(Statement)����
		Statement stm=con.createStatement();
		//ִ��Sql��䣬���ؽ������ResultSet����
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
	//ͨ��Id��ѯstudent������StudentBean����
	public StudentBean getStudentById(String stuId) throws Exception {
		con=DbConnection.getConnection();
		Statement stmt=con.createStatement();
		String strSql="select * from student where id="+stuId;
		ResultSet rs=stmt.executeQuery(strSql);
		//����Ϊ�������ݿ��д洢����
		/*CallableStatement cstm=con.prepareCall("{call getStudentById2(?,?)}");
		//����in����
		cstm.setInt(1, Integer.parseInt(stuId));
		//ע��out����
		cstm.registerOutParameter(2, java.sql.Types.VARCHAR);
		ResultSet rs=cstm.executeQuery();
		//��ȡout�����ķ���ֵ������ʾ
		String serversion=cstm.getString(2);
		System.out.println("���ݿ�������İ汾Ϊ:"+serversion);*/
		
		
		
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
	//����һ��ѧ��
	//����һ��StudentBean����Ĳ���
	public int addStudent(StudentBean student) throws Exception{
		con=DbConnection.getConnection();
		/*Statement stmt=con.createStatement();
		String sqlStr="insert into student(name,sex,class,chinese,maths,physics,chemistry) values ('"+student.getName()+"','"+student.getGender()+"','"+student.getGrade()+"',"+student.getChinese()+","+student.getMaths()+","+student.getPhysics()+","+student.getChemistry()+")";
		int rslt=stmt.executeUpdate(sqlStr);*/
		//PreparedStatement����ʵ��SQL����
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
	//�޸�ѧ����Ϣ������һ��StudentBean�������
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
	//ɾ��ѧ��������ѧ��idΪ����
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
