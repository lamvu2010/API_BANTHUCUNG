package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
@Embeddable
public class CtbanggiasanphamPK implements Serializable {
    @Column(name = "MABANGGIA", nullable = false)
    private long mabanggia;
    @Column(name = "MASANPHAM", nullable = false)
    private long masanpham;

    public long getMabanggia() {
        return mabanggia;
    }

    public void setMabanggia(long mabanggia) {
        this.mabanggia = mabanggia;
    }

    public long getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(long masanpham) {
        this.masanpham = masanpham;
    }

}
