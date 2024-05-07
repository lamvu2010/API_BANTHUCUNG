package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TAIKHOAN")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Taikhoan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TENDANGNHAP", nullable = false, length = 50)
    private String tendangnhap;

    @Column(name = "MATKHAU", nullable = true, length = 50)
    private String matkhau;

    @Column(name = "QUYEN", nullable = true)
    private Boolean quyen;

    @OneToOne
    @MapsId
    private Khachhang khachhang;

    @OneToOne
    @MapsId
    private Nhanvien nhanvien;
}
