package ptithcm.Api_BanThuCungOnline.DTO;

import java.math.BigDecimal;

public class SanPhamDTO {
    long masanpham;
    String tensanpham;
    String giahientai;
    int maloaisanpham;

    public SanPhamDTO() {
    }

    public long getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(long masanpham) {
        this.masanpham = masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getGiahientai() {
        return giahientai;
    }

    public void setGiahientai(String giahientai) {
        this.giahientai = giahientai;
    }

    public int getMaloaisanpham() {
        return maloaisanpham;
    }

    public void setMaloaisanpham(int maloaisanpham) {
        this.maloaisanpham = maloaisanpham;
    }
}
