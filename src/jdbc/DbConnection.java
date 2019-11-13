package jdbc;

import java.sql.*;

public class DbConnection {
	//定义静态方法，返回一个数据库连接
	public static Connection getConnection() {
		Connection con=null;
		String drivername="com.mysql.jdbc.Driver";
		//加上?useUnicode=true&characterEncoding=UTF-8参数，以访问UTF-8数据库
		String urlstr="jdbc:mysql://localhost:3306/jspex?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String username="root";
		String password="123qwe";
		try {
			//加载驱动程序
			Class.forName(drivername);
			System.out.println("加载驱动成功！");
		}catch(Exception e){
			System.out.println("加载驱动程序错误，程序驱动名称写错或未将驱动程序放在正确的位置");
			System.out.println(e);
		}
		try {
			//建立连接，需提供连接字符串，数据库用户及相应密码
			con=DriverManager.getConnection(urlstr,username,password);
		}catch(SQLException e) {
			System.out.println("建立连接错误，数据库url有错误，数据库服务器端口不正确、数据库不存在或用户名密码不正确");
			System.out.println(e);
		}
		return con;
	}

}
