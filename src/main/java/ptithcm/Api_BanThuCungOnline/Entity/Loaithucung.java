package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "LOAITHUCUNG")
public class Loaithucung {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MALOAITHUCUNG", nullable = false)
    private int maloaithucung;

    @Column(name = "TENLOAITHUCUNG", nullable = true, length = 50)
    private String tenloaithucung;

    @OneToMany(mappedBy = "loaithucung")
    List<Giong> giong;

    public int getMaloaithucung() {
        return maloaithucung;
    }

    public void setMaloaithucung(int maloaithucung) {
        this.maloaithucung = maloaithucung;
    }

    public String getTenloaithucung() {
        return tenloaithucung;
    }

    public void setTenloaithucung(String tenloaithucung) {
        this.tenloaithucung = tenloaithucung;
    }

}
