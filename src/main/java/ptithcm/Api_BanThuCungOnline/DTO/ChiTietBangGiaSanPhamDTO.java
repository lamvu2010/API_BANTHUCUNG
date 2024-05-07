package ptithcm.Api_BanThuCungOnline.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietBangGiaSanPhamDTO {
    private long mabanggia;
    private long masanpham;
    private String tensanpham;
    private String dongia;
    private String thoigianbatdau;
    private String thoigianketthuc;
    private String noidungbanggia;
    private String maloaibang;
    private String machinhanh;
    private String giahientai;
    private String maloaisanpham;
}
