package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.Api_BanThuCungOnline.DTO.LoaiThuCungDTO;
import ptithcm.Api_BanThuCungOnline.Entity.Loaithucung;
import ptithcm.Api_BanThuCungOnline.Services.LoaiThuCungService;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loaithucung")
public class LoaiThuCungController {
    @Autowired
    LoaiThuCungService loaiThuCungService;

    @GetMapping
    public ResponseEntity<List<Loaithucung>> findAll() {
        List<Loaithucung> list = new ArrayList<>();
        list = loaiThuCungService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        Optional<Loaithucung> loaithucung = loaiThuCungService.findById(id);
        if(loaithucung.isEmpty()){
            return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(loaithucung,HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody String tenLoaiThuCung){
        if(loaiThuCungService.existsByTenLoai(tenLoaiThuCung)){
            return new ResponseEntity<>("Entity is existed",HttpStatus.CONFLICT);
        }
        Loaithucung loaithucung = new Loaithucung();
        loaithucung.setTenloaithucung(tenLoaiThuCung);
        Loaithucung loaiThuCungSaved = loaiThuCungService.save(loaithucung);
        if(loaiThuCungSaved != null && loaiThuCungSaved.getMaloaithucung() > 0){
            return new ResponseEntity<>(loaiThuCungSaved,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Validated LoaiThuCungDTO loaiThuCungDTO){
        Loaithucung loaithucung = new Loaithucung();
        if(!loaiThuCungService.existsById(loaiThuCungDTO.getMaLoaiThuCung())){
            return new ResponseEntity<>("Entity not found",HttpStatus.NOT_FOUND);
        }
        loaithucung.setMaloaithucung(loaiThuCungDTO.getMaLoaiThuCung());
        loaithucung.setTenloaithucung(loaiThuCungDTO.getTenLoaiThuCung());
        loaiThuCungService.save(loaithucung);
        return new ResponseEntity<>(loaithucung,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean existsIdBeforeDelete = loaiThuCungService.existsById(id);
        if(!existsIdBeforeDelete){
            return new ResponseEntity<>("Entity not found",HttpStatus.NOT_FOUND);
        }

        loaiThuCungService.deleteById(id);

        boolean stillExistsAfterDelete = loaiThuCungService.existsById(id);
        if(stillExistsAfterDelete){
            return new ResponseEntity<>("Failed to delete entity",HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>("Success to delete entity",HttpStatus.OK);
        }
    }
}