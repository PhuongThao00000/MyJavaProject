package QuanLyNhaThuoc.service;

import QuanLyNhaThuoc.dao.NguoiDungDAO;
import QuanLyNhaThuoc.model.NguoiDung;
import java.util.List;

public class NguoiDungService {
    private NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();

    public List<NguoiDung> layDanhSachNguoiDung() {
        return nguoiDungDAO.getAllNguoiDung();
    }

    // Đăng nhập
    public NguoiDung dangNhap(String tenDangNhap, String matKhau) {
        for (NguoiDung nd : layDanhSachNguoiDung()) {
            if (nd.getTenDangNhap().equals(tenDangNhap) && nd.getMatKhau().equals(matKhau)) {
                return nd;
            }
        }
        return null;
    }
}