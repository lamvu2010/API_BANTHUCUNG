package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "LOAISANPHAM")
public class Loaisanpham {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MALOAISANPHAM", nullable = false)
    private int maloaisanpham;

    @Column(name = "TENLOAISANPHAM", nullable = true, length = 50)
    private String tenloaisanpham;

    @OneToMany(mappedBy = "loaisanpham")
    private List<Sanpham> sanpham;

    public int getMaloaisanpham() {
        return maloaisanpham;
    }

    public void setMaloaisanpham(int maloaisanpham) {
        this.maloaisanpham = maloaisanpham;
    }

    public String getTenloaisanpham() {
        return tenloaisanpham;
    }

    public void setTenloaisanpham(String tenloaisanpham) {
        this.tenloaisanpham = tenloaisanpham;
    }


}
