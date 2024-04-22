package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class CtmuasanphamPK implements Serializable {
    @Column(name = "SODONDAT", nullable = false)
    private long sodondat;
    @Column(name = "MASANPHAM", nullable = false)
    private long masanpham;
    @Column(name = "MACHINHANH",nullable = false)
    private long machinhanh;

    public long getSodondat() {
        return sodondat;
    }

    public void setSodondat(long sodondat) {
        this.sodondat = sodondat;
    }

    public long getMachinhanh() {
        return machinhanh;
    }

    public void setMachinhanh(long machinhanh) {
        this.machinhanh = machinhanh;
    }

    public long getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(long masanpham) {
        this.masanpham = masanpham;
    }
}
