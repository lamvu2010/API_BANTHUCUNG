package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "BANGGIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banggia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MABANGGIA", nullable = false)
    private long mabanggia;
    @Column(name = "THOIGIANBATDAU", nullable = true)
    private Date thoigianbatdau;
    @Column(name = "THOIGIANKETTHUC", nullable = true)
    private Date thoigianketthuc;
    @Column(name = "NOIDUNG", nullable = true, length = -1)
    private String noidung;
    @ManyToOne
    @JoinColumn(name = "MACHINHANH")
    private Chinhanh chinhanh;

    @OneToMany(mappedBy = "banggia")
    List<Ctbanggiasanpham> ctbanggiasanpham;

    @OneToMany(mappedBy = "banggia")
    List<Ctbanggiathucung> ctbanggiathucung;

}
