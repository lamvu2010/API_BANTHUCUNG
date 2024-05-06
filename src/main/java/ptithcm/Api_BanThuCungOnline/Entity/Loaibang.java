//package ptithcm.Api_BanThuCungOnline.Entity;
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//@Entity
//@Table(name = "LOAIBANG")
//public class Loaibang {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "MALOAIBANG", nullable = false)
//    private int maloaibang;
//
//    @Column(name = "TENLOAIBANG", nullable = true, length = 50)
//    private String tenloaibang;
//
//    @OneToMany(mappedBy = "loaibang")
//    private List<Banggia> banggia;
//
//    public int getMaloaibang() {
//        return maloaibang;
//    }
//
//    public void setMaloaibang(int maloaibang) {
//        this.maloaibang = maloaibang;
//    }
//
//    public String getTenloaibang() {
//        return tenloaibang;
//    }
//
//    public void setTenloaibang(String tenloaibang) {
//        this.tenloaibang = tenloaibang;
//    }
//
//}
