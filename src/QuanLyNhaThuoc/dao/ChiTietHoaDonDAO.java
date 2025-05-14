package QuanLyNhaThuoc.dao;

import QuanLyNhaThuoc.model.ChiTietHoaDon;
import QuanLyNhaThuoc.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAO {
    public List<ChiTietHoaDon> getAllChiTietHoaDon() {
        List<ChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietHoaDon";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon(
                    rs.getString("MaHoaDon"),
                    rs.getString("MaThuoc"),
                    rs.getInt("SoLuong"),
                    rs.getDouble("DonGia")
                );
                list.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}