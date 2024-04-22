package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "BANGGIA")
public class Banggia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MABANGGIA", nullable = false)
    private long mabanggia;
    @Column(name = "THOIGIANBATDAU", nullable = true)
    private Date thoigianbatdau;
    @Column(name = "THOIGIANKETTHUC", nullable = true)
    private Date thoigianketthuc;
    @Column(name = "NOIDUNG", nullable = true, length = -1)
    private String noidung;
    @ManyToOne
    @JoinColumn(name = "MALOAIBANG")
    private Loaibang loaibang;
    @ManyToOne
    @JoinColumn(name = "MACHINHANH")
    private Chinhanh chinhanh;

    @OneToMany(mappedBy = "banggia")
    List<Ctbanggiasanpham> ctbanggiasanpham;

    @OneToMany(mappedBy = "banggia")
    List<Ctbanggiathucung> ctbanggiathucung;

    public long getMabanggia() {
        return mabanggia;
    }

    public void setMabanggia(long mabanggia) {
        this.mabanggia = mabanggia;
    }

    public Date getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(Date thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public Date getThoigianketthuc() {
        return thoigianketthuc;
    }

    public void setThoigianketthuc(Date thoigianketthuc) {
        this.thoigianketthuc = thoigianketthuc;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Loaibang getLoaibang() {
        return loaibang;
    }

    public void setLoaibang(Loaibang loaibang) {
        this.loaibang = loaibang;
    }

    public Chinhanh getChinhanh() {
        return chinhanh;
    }

    public void setChinhanh(Chinhanh chinhanh) {
        this.chinhanh = chinhanh;
    }
}
