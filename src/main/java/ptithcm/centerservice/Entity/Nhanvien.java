package ptithcm.centerservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "NHANVIEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nhanvien {

    @Id
    @Column(name = "MANHANVIEN", nullable = false, length = 50)
    private String manhanvien;

    @Column(name = "HO", nullable = true, length = 10)
    private String ho;

    @Column(name = "TEN", nullable = true, length = 10)
    private String ten;

    @Column(name = "CCCD", nullable = true, length = 20)
    private String cccd;

    @Column(name = "CHUCVU", nullable = true, length = 20)
    private String chucvu;

    @Column(name = "SODIENTHOAI", nullable = true, length = 15)
    private String sodienthoai;

    @Column(name = "EMAIL", nullable = true, length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "MACHINHANH")
    private Chinhanh chinhanh;

    @OneToMany(mappedBy = "nhanvien")
    private List<Donnhaphang> donnhaphang;

    @OneToMany(mappedBy = "nhanvien")
    private List<Hinhanh> hinhanh;
}
