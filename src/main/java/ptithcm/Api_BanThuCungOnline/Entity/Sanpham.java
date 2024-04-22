package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SANPHAM")
public class Sanpham {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MASANPHAM", nullable = false)
    private long masanpham;

    @Column(name = "TENSANPHAM", nullable = true, length = 50)
    private String tensanpham;

    @Column(name = "GIAHIENTAI", nullable = true)
    private Object giahientai;


    @ManyToOne
    @JoinColumn(name = "MALOAISANPHAM")
    private Loaisanpham loaisanpham;

    @OneToMany(mappedBy = "sanpham")
    List<Ctbanggiasanpham> ctbanggiasanpham;

    @OneToMany(mappedBy = "sanpham")
    List<Ctnhapsanpham> ctnhapsanpham;

    @OneToMany(mappedBy = "sanpham")
    List<Ctsanpham> ctsanpham;

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

    public Object getGiahientai() {
        return giahientai;
    }

    public void setGiahientai(Object giahientai) {
        this.giahientai = giahientai;
    }

    public Loaisanpham getLoaisanpham() {
        return loaisanpham;
    }

    public void setLoaisanpham(Loaisanpham loaisanpham) {
        this.loaisanpham = loaisanpham;
    }
}
