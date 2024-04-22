package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "HOADON")
public class Hoadon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SOHOADON", nullable = false)
    private Long sohoadon;

    @Column(name = "NGAYLAP", nullable = true)
    private Date ngaylap;

    @Column(name = "TONGHOADON", nullable = true)
    private BigDecimal tonghoadon;

    @OneToOne(mappedBy = "hoadon")
    private Dondat dondat;

    public Long getSohoadon() {
        return sohoadon;
    }

    public void setSohoadon(Long sohoadon) {
        this.sohoadon = sohoadon;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public BigDecimal getTonghoadon() {
        return tonghoadon;
    }

    public void setTonghoadon(BigDecimal tonghoadon) {
        this.tonghoadon = tonghoadon;
    }

}
