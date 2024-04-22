package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "DONNHAPHANG")
public class Donnhaphang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MADONNHAPHANG", nullable = false)
    private long madonnhaphang;

    @Column(name = "NGAYLAP", nullable = true)
    private Date ngaylap;

    @ManyToOne
    @JoinColumn(name = "MANHANVIEN")
    private Nhanvien nhanvien;

    @ManyToOne
    @JoinColumn(name = "MACHINHANH")
    private Chinhanh chinhanh;

    @OneToMany(mappedBy = "donnhaphang")
    private List<Ctnhapthucung> ctnhapthucung;

    @OneToMany(mappedBy = "donnhaphang")
    private List<Ctnhapsanpham> ctnhapsanpham;

    public long getMadonnhaphang() {
        return madonnhaphang;
    }

    public void setMadonnhaphang(long madonnhaphang) {
        this.madonnhaphang = madonnhaphang;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }



}
