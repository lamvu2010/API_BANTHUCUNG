package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CTMUATHUCUNG")
public class Ctmuathucung {
    @EmbeddedId
    private CtmuathucungPK id;

    @Column(name = "DONGIA", nullable = false)
    private BigDecimal dongia;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "MADONDAT")
    private Dondat dondat;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "MATHUCUNG")
    private Thucung thucung;

    public CtmuathucungPK getId() {
        return id;
    }

    public void setId(CtmuathucungPK id) {
        this.id = id;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }
}
