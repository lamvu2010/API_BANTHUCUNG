package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class CtsanphamPK implements Serializable {
    @Column(name = "MACHINHANH", nullable = false)
    private int machinhanh;
    @Column(name = "MASANPHAM", nullable = false)
    private long masanpham;

    public int getMachinhanh() {
        return machinhanh;
    }

    public void setMachinhanh(int machinhanh) {
        this.machinhanh = machinhanh;
    }

    public long getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(long masanpham) {
        this.masanpham = masanpham;
    }

}
