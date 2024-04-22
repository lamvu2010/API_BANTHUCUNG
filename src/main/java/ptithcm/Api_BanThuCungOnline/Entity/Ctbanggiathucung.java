package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CTBANGGIATHUCUNG")
public class Ctbanggiathucung {
    @EmbeddedId
    private CtbanggiathucungPK id;

    @Column(name = "DONGIA", nullable = true)
    private BigDecimal dongia;

    @ManyToOne
    @MapsId("mabanggia")
    @JoinColumn(name = "MABANGGIA")
    Banggia banggia;

    @ManyToOne
    @MapsId("mathucung")
    @JoinColumn(name = "MATHUCUNG")
    Thucung thucung;

    public CtbanggiathucungPK getId() {
        return id;
    }

    public void setId(CtbanggiathucungPK id) {
        this.id = id;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }
}
