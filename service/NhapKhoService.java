package QuanLyNhaThuoc.service;

import QuanLyNhaThuoc.dao.NhapKhoDAO;
import QuanLyNhaThuoc.model.NhapKho;
import java.util.List;

public class NhapKhoService {
    private NhapKhoDAO nhapKhoDAO = new NhapKhoDAO();

    public List<NhapKho> layDanhSachNhapKho() {
        return nhapKhoDAO.getAllNhapKho();
    }
}