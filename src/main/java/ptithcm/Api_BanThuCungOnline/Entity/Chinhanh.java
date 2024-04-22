package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CHINHANH")
public class Chinhanh {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MACHINHANH", nullable = false)
    private int machinhanh;
    @Column(name = "TENCHINHANH", nullable = true, length = 50)
    private String tenchinhanh;

    public int getMachinhanh() {
        return machinhanh;
    }

    public void setMachinhanh(int machinhanh) {
        this.machinhanh = machinhanh;
    }

    public String getTenchinhanh() {
        return tenchinhanh;
    }

    public void setTenchinhanh(String tenchinhanh) {
        this.tenchinhanh = tenchinhanh;
    }

}
