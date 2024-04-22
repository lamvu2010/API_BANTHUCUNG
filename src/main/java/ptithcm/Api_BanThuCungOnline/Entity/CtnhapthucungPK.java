package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.io.Serializable;


@Embeddable
public class CtnhapthucungPK implements Serializable {
    @Column(name = "MADONNHAP", nullable = false)
    private long madonnhap;
    @Column(name = "MATHUCUNG", nullable = false)
    private long mathucung;

    public long getMadonnhap() {
        return madonnhap;
    }

    public void setMadonnhap(long madonnhap) {
        this.madonnhap = madonnhap;
    }

    public long getMathucung() {
        return mathucung;
    }

    public void setMathucung(long mathucung) {
        this.mathucung = mathucung;
    }

}
