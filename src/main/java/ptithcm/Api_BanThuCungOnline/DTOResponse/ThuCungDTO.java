package ptithcm.Api_BanThuCungOnline.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThuCungDTO {
    private long maThuCung;
    private String tenThuCung;
    private int trangThaiBan;
    String chu;
    String moTa;
    BigDecimal giaHienTai;
    ChiNhanhDTO chiNhanh;
    GiongDTO giong;


}
