package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CTSANPHAM")
public class Ctsanpham {

    @EmbeddedId
    private CtsanphamPK id;

    @Column(name = "SOLUONGTON", nullable = true)
    private Long soluongton;

    @Column(name = "DONGIA", nullable = true)
    private BigDecimal dongia;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "MASANPHAM")
    private Sanpham sanpham;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "MACHINHANH")
    private Chinhanh chinhanh;

    @OneToMany(mappedBy = "ctsanpham")
    private List<Ctmuasanpham> ctmuasanpham;


    public CtsanphamPK getId() {
        return id;
    }

    public void setId(CtsanphamPK id) {
        this.id = id;
    }


    public Long getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(Long soluongton) {
        this.soluongton = soluongton;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }
}
