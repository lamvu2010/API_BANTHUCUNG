package ptithcm.Api_BanThuCungOnline.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BangGiaThuCungRequest {
    private long maBangGia;
    private long maThuCung;
    private BigDecimal donGia;
}
