package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.io.Serializable;


@Embeddable
public class CtnhapsanphamPK implements Serializable {
    @Column(name = "MADONNHAP", nullable = false)
    private long madonnhap;
    @Column(name = "MASANPHAM", nullable = false)
    private long masanpham;

    public long getMadonnhap() {
        return madonnhap;
    }

    public void setMadonnhap(long madonnhap) {
        this.madonnhap = madonnhap;
    }

    public long getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(long masanpham) {
        this.masanpham = masanpham;
    }

}
