package QuanLyNhaThuoc.dao;

import QuanLyNhaThuoc.model.NguoiDung;
import QuanLyNhaThuoc.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    public List<NguoiDung> getAllNguoiDung() {
        List<NguoiDung> list = new ArrayList<>();
        String sql = "SELECT * FROM NguoiDung";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	NguoiDung nd = new NguoiDung(
            		    rs.getInt("MaNguoiDung"),
            		    rs.getString("TenDangNhap"),
            		    rs.getString("MatKhau"),
            		    rs.getString("VaiTro"),
            		    rs.getString("HoTen"),
            		    rs.getDate("NgaySinh") != null ? rs.getDate("NgaySinh").toLocalDate() : null,
            		    rs.getString("SDT"),
            		    rs.getString("Email")
            		);
                list.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}