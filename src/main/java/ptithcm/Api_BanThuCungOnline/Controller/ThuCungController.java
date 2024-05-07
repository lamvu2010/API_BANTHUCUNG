package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptithcm.Api_BanThuCungOnline.DTO.ThuCungDTO;
import ptithcm.Api_BanThuCungOnline.Entity.Thucung;
import ptithcm.Api_BanThuCungOnline.Services.ChiNhanhService;
import ptithcm.Api_BanThuCungOnline.Services.GiongService;
import ptithcm.Api_BanThuCungOnline.Services.ThuCungService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/thucung")
public class ThuCungController {
    @Autowired
    ThuCungService thuCungService;
    @Autowired
    ChiNhanhService chiNhanhService;
    @Autowired
    GiongService giongService;

    // Lay danh sach thu cung tat ca thu cung
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

    // Lay chi tiet thu cung dua vao id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        if(!thuCungService.isExistsById(id)){
            return new ResponseEntity<>("Thú cưng không tồn tại",HttpStatus.BAD_REQUEST);
        }
        Optional<Thucung> thucung = thuCungService.findById(id);
        return new ResponseEntity<>(thucung,HttpStatus.OK);
    }

    // Them thu cung
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ThuCungDTO thuCungDTO){
        Thucung thucung = new Thucung();
        thucung.setTenthucung(thuCungDTO.getTenthucung());
        thucung.setChu(thuCungDTO.getChu());
        thucung.setMota(thuCungDTO.getMota());
        thucung.setGiahientai(thuCungDTO.getGiahientai());
        thucung.setTrangthaiban(thuCungDTO.getTrangthaiban());
        thucung.setChinhanh(chiNhanhService.findById(thuCungDTO.getMachinhanh()).orElse(null));
        thucung.setGiong(giongService.findById(thuCungDTO.getMagiong()).orElse(null));
        thucung = thuCungService.save(thucung);
        if(thuCungService.isExistsById(thucung.getMathucung())){
            return new ResponseEntity<>(thucung,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Them that bai",HttpStatus.BAD_REQUEST);
        }
    }

    // Sua thông tin thu cung
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ThuCungDTO thuCungDTO){
        if(!thuCungService.isExistsById(thuCungDTO.getMathucung())){
            return new ResponseEntity<>("Thú cưng khong ton tai",HttpStatus.BAD_REQUEST);
        }
        Thucung thucung = new Thucung();
        thucung.setMathucung(thuCungDTO.getMathucung());
        thucung.setTenthucung(thuCungDTO.getTenthucung());
        thucung.setChu(thuCungDTO.getChu());
        thucung.setMota(thuCungDTO.getMota());
        thucung.setGiahientai(thuCungDTO.getGiahientai());
        thucung.setTrangthaiban(thuCungDTO.getTrangthaiban());
        thucung.setChinhanh(chiNhanhService.findById(thuCungDTO.getMachinhanh()).orElse(null));
        thucung.setGiong(giongService.findById(thuCungDTO.getMagiong()).orElse(null));
        thucung = thuCungService.save(thucung);
        return new ResponseEntity<>(thucung, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        boolean tontai = thuCungService.isExistsById(id);
        if(!tontai){
            return new ResponseEntity<>("Thú cưng không tồn tại",HttpStatus.BAD_REQUEST);
        }
        Optional<Thucung> thucung = thuCungService.findById(id);
        thuCungService.delete(thucung.orElse(null));
        tontai = thuCungService.isExistsById(id);
        if(!tontai){
            return new ResponseEntity<>("Xóa thành công",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Xóa thất bại",HttpStatus.BAD_REQUEST);
        }
    }
}
