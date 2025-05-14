package QuanLyNhaThuoc.model;

import java.time.LocalDateTime;

public class NhapKho {
    private String maNhapKho;
    private LocalDateTime ngayNhap;
    private int maNguoiDung;

    public NhapKho(String maNhapKho, LocalDateTime ngayNhap, int maNguoiDung) {
        this.maNhapKho = maNhapKho;
        this.ngayNhap = ngayNhap;
        this.maNguoiDung = maNguoiDung;
    }

    public String getMaNhapKho() { return maNhapKho; }
    public void setMaNhapKho(String maNhapKho) { this.maNhapKho = maNhapKho; }
    public LocalDateTime getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(LocalDateTime ngayNhap) { this.ngayNhap = ngayNhap; }
    public int getMaNguoiDung() { return maNguoiDung; }
    public void setMaNguoiDung(int maNguoiDung) { this.maNguoiDung = maNguoiDung; }

    @Override
    public String toString() {
        return "NhapKho{" +
                "maNhapKho='" + maNhapKho + '\'' +
                ", ngayNhap=" + ngayNhap +
                ", maNguoiDung=" + maNguoiDung +
                '}';
    }
}
