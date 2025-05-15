package QuanLyNhaThuoc.service;

import QuanLyNhaThuoc.dao.ChiTietHoaDonDAO;
import QuanLyNhaThuoc.model.ChiTietHoaDon;
import java.util.List;

public class ChiTietHoaDonService {
    private ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();

    public List<ChiTietHoaDon> layDanhSachChiTietHoaDon() {
        return chiTietHoaDonDAO.getAllChiTietHoaDon();
    }
}