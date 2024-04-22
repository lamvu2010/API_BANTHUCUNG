package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "GIONG")
public class Giong {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MAGIONG", nullable = false)
    private int magiong;

    @Column(name = "TENGIONG", nullable = true, length = 50)
    private String tengiong;

    @ManyToOne
    @JoinColumn(name = "MALOAITHUCUNG")
    private Loaithucung loaithucung;

    @OneToMany(mappedBy = "giong")
    private List<Thucung> thucung;

    public int getMagiong() {
        return magiong;
    }

    public void setMagiong(int magiong) {
        this.magiong = magiong;
    }

    public String getTengiong() {
        return tengiong;
    }

    public void setTengiong(String tengiong) {
        this.tengiong = tengiong;
    }

    public Loaithucung getLoaithucung() {
        return loaithucung;
    }

    public void setLoaithucung(Loaithucung loaithucung) {
        this.loaithucung = loaithucung;
    }
}
