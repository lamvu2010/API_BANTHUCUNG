package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CTBANGGIASANPHAM")
public class Ctbanggiasanpham {
    @EmbeddedId
    private CtbanggiasanphamPK id;

    @ManyToOne
    @MapsId("mabanggia")
    @JoinColumn(name = "MABANGGIA")
    private Banggia banggia;

    @ManyToOne
    @MapsId("masanpham")
    @JoinColumn(name="MASANPHAM")
    private Sanpham sanpham;

    @Column(name = "DONGIA", nullable = true)
    private BigDecimal dongia;

    public CtbanggiasanphamPK getId() {
        return id;
    }

    public void setId(CtbanggiasanphamPK id) {
        this.id = id;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }

    public Sanpham getSanpham() {
        return sanpham;
    }

    public void setSanpham(Sanpham sanpham) {
        this.sanpham = sanpham;
    }

    public Banggia getBanggia() {
        return banggia;
    }

    public void setBanggia(Banggia banggia) {
        this.banggia = banggia;
    }
}
