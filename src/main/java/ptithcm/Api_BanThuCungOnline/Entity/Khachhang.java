package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "KHACHHANG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Khachhang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MAKHACHHANG", nullable = false, length = 50)
    private String makhachhang;

    @Column(name = "HO", nullable = true, length = 10)
    private String ho;

    @Column(name = "TEN", nullable = true, length = 10)
    private String ten;

    @Column(name = "GIOITINH", nullable = true)
    private Boolean gioitinh;

    @Column(name = "NGAYSINH", nullable = true)
    private Date ngaysinh;

    @Column(name = "DIACHI", nullable = true, length = 50)
    private String diachi;

    @Column(name = "HINHANH", nullable = true, length = 1)
    private String hinhanh;

    @Column(name = "SODIENTHOAI", nullable = true, length = 15)
    private String sodienthoai;

    @Column(name = "EMAIL", nullable = true, length = 50)
    private String email;

    @Column(name = "CCCD", nullable = true, length = 20)
    private String cccd;

    @OneToOne(mappedBy = "khachhang")
    private Taikhoan taikhoan;

    @OneToMany(mappedBy = "khachhang")
    private List<Dondat> dondat;
}
