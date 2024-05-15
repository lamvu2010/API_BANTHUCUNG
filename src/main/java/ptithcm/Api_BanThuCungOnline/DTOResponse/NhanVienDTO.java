package ptithcm.Api_BanThuCungOnline.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienDTO {
    private String maNhanVien;
    private String ho;
    private String ten;
    private String cccd;
    private String chucVu;
    private String soDienThoai;
    private String email;
    ChiNhanhDTO chiNhanh;
}
