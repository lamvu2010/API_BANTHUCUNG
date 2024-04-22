package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "DONDAT")
public class Dondat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SODONDAT", nullable = false)
    private long sodondat;

    @Column(name = "NGAYLAP", nullable = true)
    private Date ngaylap;

    @Column(name = "DIACHIDAT", nullable = true, length = 50)
    private String diachidat;

    @Column(name = "SODIENTHOAI", nullable = true, length = 15)
    private String sodienthoai;

    @ManyToOne
    @JoinColumn(name = "MACHINHANH")
    private Chinhanh chinhanh;

    @ManyToOne
    @JoinColumn(name = "MAKHACHHANG")
    private Khachhang khachhang;

    @OneToOne
    @MapsId
    private Hoadon hoadon;

    @OneToMany(mappedBy = "dondat")
    private List<Ctmuasanpham> ctmuasanpham;

    @OneToMany(mappedBy = "dondat")
    private List<Ctmuathucung> ctmuathucung;

    public long getSodondat() {
        return sodondat;
    }

    public void setSodondat(long sodondat) {
        this.sodondat = sodondat;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getDiachidat() {
        return diachidat;
    }

    public void setDiachidat(String diachidat) {
        this.diachidat = diachidat;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public Chinhanh getChinhanh() {
        return chinhanh;
    }

    public void setChinhanh(Chinhanh chinhanh) {
        this.chinhanh = chinhanh;
    }

    public Khachhang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Khachhang khachhang) {
        this.khachhang = khachhang;
    }
}
