package jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
 
 
public class ConnectionDemo {
 
    public static void main(String[] args) throws SQLException {
        System.out.println("ʹ�����ӳ�................................");
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
            System.out.println("��" + (i + 1) + "��ִ�л���ʱ��Ϊ:" + (endTime - beginTime));
        }
 
        System.out.println("��ʹ�����ӳ�................................");
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
            System.out.println("��" + (i + 1) + "��ִ�л���ʱ��Ϊ:"+ (endTime - beginTime));
        }
    }}