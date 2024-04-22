package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CTNHAPSANPHAM")
public class Ctnhapsanpham {

    @EmbeddedId
    private CtnhapsanphamPK id;

    @Column(name = "SOLUONG", nullable = true)
    private Integer soluong;

    @Column(name = "DONGIA", nullable = true)
    private BigDecimal dongia;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "MADONNHAP")
    private Donnhaphang donnhaphang;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "MASANPHAM")
    private Sanpham sanpham;

    public CtnhapsanphamPK getId() {
        return id;
    }

    public void setId(CtnhapsanphamPK id) {
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
