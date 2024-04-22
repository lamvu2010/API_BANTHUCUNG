package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class CtbanggiathucungPK implements Serializable {
    @Column(name = "MABANGGIA", nullable = false)
    private long mabanggia;
    @Column(name = "MATHUCUNG", nullable = false)
    private long mathucung;

    public long getMabanggia() {
        return mabanggia;
    }

    public void setMabanggia(long mabanggia) {
        this.mabanggia = mabanggia;
    }

    public long getMathucung() {
        return mathucung;
    }

    public void setMathucung(long mathucung) {
        this.mathucung = mathucung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CtbanggiathucungPK that = (CtbanggiathucungPK) o;

        if (mabanggia != that.mabanggia) return false;
        if (mathucung != that.mathucung) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mabanggia ^ (mabanggia >>> 32));
        result = 31 * result + (int) (mathucung ^ (mathucung >>> 32));
        return result;
    }
}
