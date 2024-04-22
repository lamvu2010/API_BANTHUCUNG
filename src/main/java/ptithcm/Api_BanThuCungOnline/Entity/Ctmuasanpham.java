package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CTMUASANPHAM")
public class Ctmuasanpham {
    @EmbeddedId
    private CtmuasanphamPK id;

    @Column(name = "SOLUONG", nullable = true)
    private Integer soluong;

    @Column(name = "DONGIA", nullable = true)
    private BigDecimal dongia;

    @ManyToOne
    @MapsId("sodondat")
    @JoinColumn(name = "SOLUONGDAT")
    private Dondat dondat;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "MACHINHANH", referencedColumnName = "MACHINHANH",insertable = false,updatable = false),
            @JoinColumn(name = "MASANPHAM", referencedColumnName = "MASANPHAM",insertable = false,updatable = false)
    })
    private Ctsanpham ctsanpham;


    public CtmuasanphamPK getId() {
        return id;
    }

    public void setId(CtmuasanphamPK id) {
        this.id = id;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }
}
