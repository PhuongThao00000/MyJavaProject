package QuanLyNhaThuoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestKetNoi {
    public static void main(String[] args) {
        try {
            // 1. Nạp trình điều khiển
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Tạo thông tin kết nối và đối tượng Connection
            String url = "jdbc:mysql://localhost:3306/QuanLyNhaThuoc";
            String user = "root";
            String password = "123456789";
            Connection conn = DriverManager.getConnection(url, user, password);

            // 3. Tạo đối tượng Statement để thực thi các lệnh truy vấn SQL
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Thuoc";
            ResultSet rs = stmt.executeQuery(sql);

            // 4. Xử lý dữ liệu
            while (rs.next()) {
                String maThuoc = rs.getString("MaThuoc");
                String tenThuoc = rs.getString("TenThuoc");
                System.out.println(maThuoc + " - " + tenThuoc);
            }

            // 5. Đóng kết nối
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}