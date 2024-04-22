package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CTNHAPTHUCUNG")
public class Ctnhapthucung {
    @EmbeddedId
    private CtnhapthucungPK id;

    @Column(name = "GIANHAP", nullable = true)
    private BigDecimal gianhap;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "MADONNHAP")
    private Donnhaphang donnhaphang;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "MATHUCUNG")
    private Thucung thucung;

    public CtnhapthucungPK getId() {
        return id;
    }

    public void setId(CtnhapthucungPK id) {
        this.id = id;
    }

    public BigDecimal getGianhap() {
        return gianhap;
    }

    public void setGianhap(BigDecimal gianhap) {
        this.gianhap = gianhap;
    }
}
