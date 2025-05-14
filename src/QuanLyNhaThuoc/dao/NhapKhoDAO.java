package QuanLyNhaThuoc.dao;

import QuanLyNhaThuoc.model.NhapKho;
import QuanLyNhaThuoc.DBConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NhapKhoDAO {
    public List<NhapKho> getAllNhapKho() {
        List<NhapKho> list = new ArrayList<>();
        String sql = "SELECT * FROM NhapKho";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                NhapKho nk = new NhapKho(
                    rs.getString("MaNhapKho"),
                    rs.getTimestamp("NgayNhap").toLocalDateTime(),
                    rs.getInt("MaNguoiDung")
                );
                list.add(nk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}