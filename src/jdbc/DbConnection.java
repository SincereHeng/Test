package jdbc;

import java.sql.*;

public class DbConnection {
	//���徲̬����������һ�����ݿ�����
	public static Connection getConnection() {
		Connection con=null;
		String drivername="com.mysql.jdbc.Driver";
		//����?useUnicode=true&characterEncoding=UTF-8�������Է���UTF-8���ݿ�
		String urlstr="jdbc:mysql://localhost:3306/jspex?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String username="root";
		String password="123qwe";
		try {
			//������������
			Class.forName(drivername);
			System.out.println("���������ɹ���");
		}catch(Exception e){
			System.out.println("��������������󣬳�����������д���δ���������������ȷ��λ��");
			System.out.println(e);
		}
		try {
			//�������ӣ����ṩ�����ַ��������ݿ��û�����Ӧ����
			con=DriverManager.getConnection(urlstr,username,password);
		}catch(SQLException e) {
			System.out.println("�������Ӵ������ݿ�url�д������ݿ�������˿ڲ���ȷ�����ݿⲻ���ڻ��û������벻��ȷ");
			System.out.println(e);
		}
		return con;
	}

}
