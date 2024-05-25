package ptithcm.centerservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CtmuathucungPK implements Serializable {
    @Column(name = "MADONDAT", nullable = false)
    private long madondat;
    @Column(name = "MATHUCUNG", nullable = false)
    private long mathucung;
}
