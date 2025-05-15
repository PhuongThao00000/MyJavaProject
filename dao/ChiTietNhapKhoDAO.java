package QuanLyNhaThuoc.dao;

import QuanLyNhaThuoc.model.ChiTietNhapKho;
import QuanLyNhaThuoc.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiTietNhapKhoDAO {
    public List<ChiTietNhapKho> getAllChiTietNhapKho() {
        List<ChiTietNhapKho> list = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietNhapKho";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ChiTietNhapKho ct = new ChiTietNhapKho(
                    rs.getString("MaNhapKho"),
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