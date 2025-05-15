package QuanLyNhaThuoc.model;

public class ChiTietNhapKho {
    private String maNhapKho;
    private String maThuoc;
    private int soLuong;
    private double donGia;

    public ChiTietNhapKho(String maNhapKho, String maThuoc, int soLuong, double donGia) {
        this.maNhapKho = maNhapKho;
        this.maThuoc = maThuoc;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaNhapKho() { return maNhapKho; }
    public void setMaNhapKho(String maNhapKho) { this.maNhapKho = maNhapKho; }
    public String getMaThuoc() { return maThuoc; }
    public void setMaThuoc(String maThuoc) { this.maThuoc = maThuoc; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }

    @Override
    public String toString() {
        return "ChiTietNhapKho{" +
                "maNhapKho='" + maNhapKho + '\'' +
                ", maThuoc='" + maThuoc + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                '}';
    }
}
