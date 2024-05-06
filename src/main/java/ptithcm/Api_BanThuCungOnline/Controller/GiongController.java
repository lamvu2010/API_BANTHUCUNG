package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptithcm.Api_BanThuCungOnline.DTO.GiongDTO;
import ptithcm.Api_BanThuCungOnline.Entity.Giong;
import ptithcm.Api_BanThuCungOnline.Services.GiongService;
import ptithcm.Api_BanThuCungOnline.Services.LoaiThuCungService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/giong")
public class GiongController {
    @Autowired
    GiongService giongService;
    @Autowired
    LoaiThuCungService loaiThuCungService;

    @GetMapping
    public ResponseEntity<List<Giong>> findAll(){
        List<Giong> list = new ArrayList<>();
        list = giongService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Giong> insert(@RequestBody GiongDTO giongDTO){
        Giong giong = new Giong();
        giong.setTengiong(giongDTO.getTengiong());
        giong.setLoaithucung(loaiThuCungService.findById(giongDTO.getIdLoaiThuCung()).orElse(null));
        giong = giongService.save(giong);
        if (giongService.isExistsById(giong.getMagiong())){
            return new ResponseEntity<>(giong,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(giong,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody GiongDTO giongDTO){
        if(!giongService.isExistsById(giongDTO.getId())){
            return new ResponseEntity<>("Giống không tồn tại",HttpStatus.BAD_REQUEST);
        }

        Giong giong = new Giong();
        giong.setMagiong(giongDTO.getId());
        giong.setTengiong(giongDTO.getTengiong());
        giong.setLoaithucung(loaiThuCungService.findById(giongDTO.getId()).orElse(null));
        giongService.save(giong);
        return new ResponseEntity<>(giong,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean tontai = giongService.isExistsById(id);
        if(!tontai){
            return new ResponseEntity<>("Giống không tồn tại",HttpStatus.BAD_REQUEST);
        }
        else{
            giongService.delete(giongService.findById(id).orElse(null));
            return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
        }
    }
}
