package ptithcm.Api_BanThuCungOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "CTMUATHUCUNG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ctmuathucung {
    @EmbeddedId
    private CtmuathucungPK id;

    @Column(name = "DONGIA", nullable = false)
    private BigDecimal dongia;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "MADONDAT")
    private Dondat dondat;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "MATHUCUNG")
    private Thucung thucung;
}
