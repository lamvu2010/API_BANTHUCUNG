package ptithcm.Api_BanThuCungOnline.DTO;


public class LoaiThuCungDTO {

    int maLoaiThuCung;
    String tenLoaiThuCung;

    public LoaiThuCungDTO() {
    }

    public int getMaLoaiThuCung() {
        return maLoaiThuCung;
    }

    public void setMaLoaiThuCung(int maLoaiThuCung) {
        this.maLoaiThuCung = maLoaiThuCung;
    }

    public String getTenLoaiThuCung() {
        return tenLoaiThuCung;
    }

    public void setTenLoaiThuCung(String tenLoaiThuCung) {
        this.tenLoaiThuCung = tenLoaiThuCung;
    }
}