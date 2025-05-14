package QuanLyNhaThuoc.dao;

import QuanLyNhaThuoc.model.Thuoc;
import QuanLyNhaThuoc.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ThuocDAO {
    public List<Thuoc> getAllThuoc() {
        List<Thuoc> list = new ArrayList<>();
        String sql = "SELECT * FROM Thuoc";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Thuoc t = new Thuoc(
                    rs.getString("MaThuoc"),
                    rs.getString("TenThuoc"),
                    rs.getString("NhomThuoc"),
                    rs.getDate("HanDung").toLocalDate(),
                    rs.getInt("SoLuong"),
                    rs.getDouble("GiaBan")
                );
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm, sửa, xóa, tìm kiếm có thể bổ sung sau
}