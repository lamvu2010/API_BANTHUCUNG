package ptithcm.Api_BanThuCungOnline.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamDTO {
    long masanpham;
    String tensanpham;
    BigDecimal giahientai;
    int maloaisanpham;
}
