package QuanLyNhaThuoc.dao;

import QuanLyNhaThuoc.model.HoaDon;
import QuanLyNhaThuoc.DBConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO {
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                HoaDon hd = new HoaDon(
                    rs.getString("MaHoaDon"),
                    rs.getTimestamp("NgayBan").toLocalDateTime(),
                    rs.getDouble("TongTien"),
                    rs.getInt("MaNguoiDung")
                );
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}