package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "TAIKHOAN")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Taikhoan{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TENDANGNHAP", nullable = false, length = 50)
    private String tendangnhap;

    @Column(name = "MATKHAU", nullable = true, length = 50)
    private String matkhau;

    @Column(name = "QUYEN", nullable = true)
    private Boolean quyen;

    @OneToOne(cascade = CascadeType.PERSIST,optional = false,fetch = FetchType.EAGER)
    @MapsId
    @PrimaryKeyJoinColumn
    @Fetch(FetchMode.JOIN)
    private Khachhang khachhang;

    @OneToOne
    @MapsId
    @JoinColumn(name="TENDANGNHAP")
    private Nhanvien nhanvien;

}
