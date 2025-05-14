package QuanLyNhaThuoc.service;

import QuanLyNhaThuoc.dao.ChiTietNhapKhoDAO;
import QuanLyNhaThuoc.model.ChiTietNhapKho;
import java.util.List;

public class ChiTietNhapKhoService {
    private ChiTietNhapKhoDAO chiTietNhapKhoDAO = new ChiTietNhapKhoDAO();

    public List<ChiTietNhapKho> layDanhSachChiTietNhapKho() {
        return chiTietNhapKhoDAO.getAllChiTietNhapKho();
    }
}