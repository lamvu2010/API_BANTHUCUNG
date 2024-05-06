package ptithcm.Api_BanThuCungOnline.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThuCungDTO {
    long mathucung;
    String tenthucung;
    int trangthaiban;
    String chu;
    String mota;
    BigDecimal giahientai;
    int machinhanh;
    int magiong;
}
