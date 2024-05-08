package ptithcm.Api_BanThuCungOnline.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamDTO {
    long maSanPham;
    String tenSanPham;
    BigDecimal giaHienTai;
    LoaiSanPhamDTO loaiSanPham;
}
