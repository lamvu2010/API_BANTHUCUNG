package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "NHANVIEN")
public class Nhanvien {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MANHANVIEN", nullable = false, length = 50)
    private String manhanvien;

    @Column(name = "HO", nullable = true, length = 10)
    private String ho;

    @Column(name = "TEN", nullable = true, length = 10)
    private String ten;

    @Column(name = "CCCD", nullable = true, length = 20)
    private String cccd;

    @Column(name = "SOBAOHIEM", nullable = true, length = 30)
    private String sobaohiem;

    @Column(name = "MASOTHUE", nullable = true, length = 30)
    private String masothue;

    @Column(name = "MAHOPDONG", nullable = true, length = 40)
    private String mahopdong;

    @Column(name = "CHUCVU", nullable = true, length = 20)
    private String chucvu;

    @Column(name = "SODIENTHOAI", nullable = true, length = 15)
    private String sodienthoai;

    @Column(name = "EMAIL", nullable = true, length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "chinhanh")
    private Chinhanh chinhanh;

    @OneToOne(mappedBy = "nhanvien")
    Taikhoan taikhoan;

    @OneToMany(mappedBy = "nhanvien")
    List<Donnhaphang> donnhaphang;

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSobaohiem() {
        return sobaohiem;
    }

    public void setSobaohiem(String sobaohiem) {
        this.sobaohiem = sobaohiem;
    }

    public String getMasothue() {
        return masothue;
    }

    public void setMasothue(String masothue) {
        this.masothue = masothue;
    }

    public String getMahopdong() {
        return mahopdong;
    }

    public void setMahopdong(String mahopdong) {
        this.mahopdong = mahopdong;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Chinhanh getChinhanh() {
        return chinhanh;
    }

    public void setChinhanh(Chinhanh chinhanh) {
        this.chinhanh = chinhanh;
    }

    public Taikhoan getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(Taikhoan taikhoan) {
        this.taikhoan = taikhoan;
    }
}
