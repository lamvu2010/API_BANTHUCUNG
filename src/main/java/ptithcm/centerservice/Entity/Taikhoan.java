package ptithcm.centerservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "TAIKHOAN")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Taikhoan {
    @Id
    @Column(name = "TENDANGNHAP", nullable = false, length = 50)
    private String tendangnhap;

    @Column(name = "MATKHAU", nullable = true, length = 50)
    private String matkhau;

    @Column(name = "QUYEN", nullable = true)
    private Boolean quyen;

    @Column(name = "TRANGTHAI", nullable = true)
    private Boolean trangthai;

    @Column(name = "MAXACNHAN", nullable = true)
    private String maxacnhan;

    @Column(name = "THOIGIANXACNHAN", nullable = true)
    private LocalDateTime thoigianxacnhan;

    @Column(name = "THOIGIANTAOMA", nullable = true)
    private LocalDateTime thoigiantaoma;

    @Column(name = "THOIGIANHETHAN", nullable = true)
    private LocalDateTime thoigianhethan;
}
