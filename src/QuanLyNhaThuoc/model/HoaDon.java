package QuanLyNhaThuoc.model;

import java.time.LocalDateTime;

public class HoaDon {
    private String maHoaDon;
    private LocalDateTime ngayBan;
    private double tongTien;
    private int maNguoiDung;

    public HoaDon(String maHoaDon, LocalDateTime ngayBan, double tongTien, int maNguoiDung) {
        this.maHoaDon = maHoaDon;
        this.ngayBan = ngayBan;
        this.tongTien = tongTien;
        this.maNguoiDung = maNguoiDung;
    }

    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }
    public LocalDateTime getNgayBan() { return ngayBan; }
    public void setNgayBan(LocalDateTime ngayBan) { this.ngayBan = ngayBan; }
    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }
    public int getMaNguoiDung() { return maNguoiDung; }
    public void setMaNguoiDung(int maNguoiDung) { this.maNguoiDung = maNguoiDung; }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", ngayBan=" + ngayBan +
                ", tongTien=" + tongTien +
                ", maNguoiDung=" + maNguoiDung +
                '}';
    }
}
