package QuanLyNhaThuoc.service;

import QuanLyNhaThuoc.dao.HoaDonDAO;
import QuanLyNhaThuoc.model.HoaDon;
import java.util.List;

public class HoaDonService {
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();

    public List<HoaDon> layDanhSachHoaDon() {
        return hoaDonDAO.getAllHoaDon();
    }

    // Thêm các hàm nghiệp vụ khác nếu cần
}