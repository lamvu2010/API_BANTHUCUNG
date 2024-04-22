package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TAIKHOAN")
public class Taikhoan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TENDANGNHAP", nullable = false, length = 50)
    private String tendangnhap;

    @Column(name = "MATKHAU", nullable = true, length = 50)
    private String matkhau;

    @Column(name = "QUYEN", nullable = true)
    private Boolean quyen;

    @OneToOne
    @MapsId
    private Khachhang khachhang;

    @OneToOne
    @MapsId
    private Nhanvien nhanvien;


    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Boolean getQuyen() {
        return quyen;
    }

    public void setQuyen(Boolean quyen) {
        this.quyen = quyen;
    }

}
