package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.Api_BanThuCungOnline.DTO.ThuCungDTO;
import ptithcm.Api_BanThuCungOnline.Entity.Thucung;
import ptithcm.Api_BanThuCungOnline.Services.ThuCungService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/thucung")
public class ThuCungController {
    @Autowired
    ThuCungService thuCungService;

    @GetMapping
    public ResponseEntity<List<ThuCungDTO>> getAll(){
        List<ThuCungDTO> dtoList = new ArrayList<>();
        List<Thucung> thucungList = new ArrayList<>();
        thucungList = thuCungService.findAll();
        for (Thucung thucung : thucungList){
            ThuCungDTO thuCungDTO = new ThuCungDTO();
            thuCungDTO.setMathucung(thucung.getMathucung());
            thuCungDTO.setTenthucung(thucung.getTenthucung());
            thuCungDTO.setTrangthaiban(thucung.getTrangthaiban());
            thuCungDTO.setChu(thucung.getChu());
            thuCungDTO.setGiahientai(thucung.getGiahientai());
            thuCungDTO.setMota(thucung.getMota());
            // thucung.getChiNhanh() là giá trị null thì không thể getMaChiNhanh();
            // cần kiểm tra
            if(thucung.getChinhanh()!=null){
                thuCungDTO.setMachinhanh(thucung.getChinhanh().getMachinhanh());
            }
            if(thucung.getGiong()!= null){
                thuCungDTO.setMagiong(thucung.getGiong().getMagiong());
            }
            // kieu int khong the gan gia trị null
            // neu khong gán giá trị, mã giống và mã chi nhánh mặc định bằng 0
            // chuẩn json
            dtoList.add(thuCungDTO);
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
