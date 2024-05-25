package ptithcm.centerservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "CTMUASANPHAM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ctmuasanpham {
    @EmbeddedId
    private CtmuasanphamPK id;

    @Column(name = "SOLUONG", nullable = true)
    private Integer soluong;

    @Column(name = "DONGIA", nullable = true)
    private BigDecimal dongia;

    @ManyToOne
    @MapsId("sodondat")
    @JoinColumn(name = "SOLUONGDAT")
    private Dondat dondat;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "MACHINHANH", referencedColumnName = "MACHINHANH",insertable = false,updatable = false),
            @JoinColumn(name = "MASANPHAM", referencedColumnName = "MASANPHAM",insertable = false,updatable = false)
    })
    private Ctsanpham ctsanpham;
}
