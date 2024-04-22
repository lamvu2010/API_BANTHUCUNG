package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "THUCUNG")
public class Thucung {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MATHUCUNG", nullable = false)
    private long mathucung;

    @Column(name = "TENTHUCUNG", nullable = true, length = 50)
    private String tenthucung;

    @Column(name = "TRANGTHAIBAN", nullable = true)
    private Integer trangthaiban;

    @Column(name = "CHU", nullable = true, length = 50)
    private String chu;

    @Column(name = "MOTA", nullable = true, length = -1)
    private String mota;

    @Column(name = "GIAHIENTAI", nullable = true)
    private BigDecimal giahientai;

    @OneToMany(mappedBy = "thucung")
    List<Ctbanggiathucung> ctbanggiathucung;

    @ManyToOne
    @JoinColumn(name = "MACHINHANH")
    private Chinhanh chinhanh;

    @ManyToOne
    @JoinColumn(name = "MAGIONG")
    private Giong giong;

    public long getMathucung() {
        return mathucung;
    }

    public void setMathucung(long mathucung) {
        this.mathucung = mathucung;
    }

    public String getTenthucung() {
        return tenthucung;
    }

    public void setTenthucung(String tenthucung) {
        this.tenthucung = tenthucung;
    }

    public Integer getTrangthaiban() {
        return trangthaiban;
    }

    public void setTrangthaiban(Integer trangthaiban) {
        this.trangthaiban = trangthaiban;
    }

    public String getChu() {
        return chu;
    }

    public void setChu(String chu) {
        this.chu = chu;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public BigDecimal getGiahientai() {
        return giahientai;
    }

    public void setGiahientai(BigDecimal giahientai) {
        this.giahientai = giahientai;
    }

    public Giong getGiong() {
        return giong;
    }

    public void setGiong(Giong giong) {
        this.giong = giong;
    }

    public Chinhanh getChinhanh() {
        return chinhanh;
    }

    public void setChinhanh(Chinhanh chinhanh) {
        this.chinhanh = chinhanh;
    }
}
