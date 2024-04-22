package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class CtmuathucungPK implements Serializable {
    @Column(name = "MADONDAT", nullable = false)
    private long madondat;
    @Column(name = "MATHUCUNG", nullable = false)
    private long mathucung;

    public long getMadondat() {
        return madondat;
    }

    public void setMadondat(long madondat) {
        this.madondat = madondat;
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

        CtmuathucungPK that = (CtmuathucungPK) o;

        if (madondat != that.madondat) return false;
        if (mathucung != that.mathucung) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (madondat ^ (madondat >>> 32));
        result = 31 * result + (int) (mathucung ^ (mathucung >>> 32));
        return result;
    }
}
