package ptithcm.Api_BanThuCungOnline.DTO;

public class LoaiSanPhamDTO {
    int maLoaiSanPham;
    String tenLoaiSanPham;

    public LoaiSanPhamDTO() {
    }

    public int getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }
}
