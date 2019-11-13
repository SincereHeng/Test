package jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
 
 
public class ConnectionDemo {
 
    public static void main(String[] args) throws SQLException {
        System.out.println("使用连接池................................");
        for (int i = 0; i < 20; i++) {
            long beginTime = System.currentTimeMillis();
            Connection conn = ConnectionManager.getInstance().getConnection();
            try {
                PreparedStatement pstmt = conn.prepareStatement("select * from student");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                	 // do nothing...
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
 
            long endTime = System.currentTimeMillis();
            System.out.println("第" + (i + 1) + "次执行花费时间为:" + (endTime - beginTime));
        }
 
        System.out.println("不使用连接池................................");
        for (int i = 0; i < 20; i++) {
            long beginTime = System.currentTimeMillis();
           	MysqlDataSource mds = new MysqlDataSource();
           	mds.setURL("jdbc:mysql://localhost:3306/jspex");
            mds.setUser("root");
            mds.setPassword("123qwe");
            Connection conn = mds.getConnection();
            try {
                PreparedStatement pstmt = conn.prepareStatement("select * from student");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                                    // do nothing...
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("第" + (i + 1) + "次执行花费时间为:"+ (endTime - beginTime));
        }
    }}