package QuanLyNhaThuoc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Nạp driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Thông tin kết nối
            String url = "jdbc:mysql://localhost:3306/QuanLyNhaThuoc";
            String user = "root"; // Đổi thành user MySQL của bạn
            String password = "123456789"; // Đổi thành mật khẩu MySQL của bạn
            // Tạo kết nối
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}