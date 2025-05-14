package QuanLyNhaThuoc.service;

import QuanLyNhaThuoc.dao.ThuocDAO;
import QuanLyNhaThuoc.model.Thuoc;
import java.util.List;

public class ThuocService {
    private ThuocDAO thuocDAO = new ThuocDAO();

    public List<Thuoc> layDanhSachThuoc() {
        return thuocDAO.getAllThuoc();
    }

    // Thêm các hàm nghiệp vụ khác nếu cần
}