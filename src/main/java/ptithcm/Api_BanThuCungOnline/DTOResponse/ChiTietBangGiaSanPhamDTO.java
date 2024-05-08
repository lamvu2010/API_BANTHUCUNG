package ptithcm.Api_BanThuCungOnline.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietBangGiaSanPhamDTO {
    private long mabanggia;
    private long masanpham;
    private String tensanpham;
    private BigDecimal dongia;
    private Date thoigianbatdau;
    private Date thoigianketthuc;
    private String noidungbanggia;
    private int machinhanh;
    private BigDecimal giahientai;
    private int maloaisanpham;
}
