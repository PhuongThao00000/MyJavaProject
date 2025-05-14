package QuanLyNhaThuoc.model;

import java.time.LocalDate;

public class Thuoc {
    private String maThuoc;
    private String tenThuoc;
    private String nhomThuoc;
    private LocalDate hanDung;
    private int soLuong;
    private double giaBan;

    public Thuoc(String maThuoc, String tenThuoc, String nhomThuoc, LocalDate hanDung, int soLuong, double giaBan) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.nhomThuoc = nhomThuoc;
        this.hanDung = hanDung;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getMaThuoc() { return maThuoc; }
    public void setMaThuoc(String maThuoc) { this.maThuoc = maThuoc; }
    public String getTenThuoc() { return tenThuoc; }
    public void setTenThuoc(String tenThuoc) { this.tenThuoc = tenThuoc; }
    public String getNhomThuoc() { return nhomThuoc; }
    public void setNhomThuoc(String nhomThuoc) { this.nhomThuoc = nhomThuoc; }
    public LocalDate getHanDung() { return hanDung; }
    public void setHanDung(LocalDate hanDung) { this.hanDung = hanDung; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public double getGiaBan() { return giaBan; }
    public void setGiaBan(double giaBan) { this.giaBan = giaBan; }

    @Override
    public String toString() {
        return "Thuoc{" +
                "maThuoc='" + maThuoc + '\'' +
                ", tenThuoc='" + tenThuoc + '\'' +
                ", nhomThuoc='" + nhomThuoc + '\'' +
                ", hanDung=" + hanDung +
                ", soLuong=" + soLuong +
                ", giaBan=" + giaBan +
                '}';
    }
}
