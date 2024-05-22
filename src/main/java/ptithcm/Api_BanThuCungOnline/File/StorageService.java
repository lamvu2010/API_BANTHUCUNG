package ptithcm.Api_BanThuCungOnline.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ptithcm.Api_BanThuCungOnline.Entity.Hinhanh;
import ptithcm.Api_BanThuCungOnline.Entity.Nhanvien;
import ptithcm.Api_BanThuCungOnline.Repositories.*;
import ptithcm.Api_BanThuCungOnline.Services.KhachHangService;
import ptithcm.Api_BanThuCungOnline.Services.NhanVienService;
import ptithcm.Api_BanThuCungOnline.Services.SanPhamService;
import ptithcm.Api_BanThuCungOnline.Services.ThuCungService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.UUID;

@Service
public class StorageService {

    @Autowired
    private HinhAnhRepo hinhAnhRepo;
    @Autowired
    private NhanVienRepo nhanVienRepo;
    @Autowired
    private KhachHangRepo khachHangRepo;
    @Autowired
    private ThuCungRepo thuCungRepo;
    @Autowired
    private SanPhamRepo sanPhamRepo;


    private final String FOLDER_PATH = "D:/HUONG DICH VU/Project/Api_BanThuCungOnline/src/main/java/ptithcm/Api_BanThuCungOnline/HinhAnh/";

    public String uploadImageToFileSystem(MultipartFile file, String maNhanVien, String maKhachHang, Long maThuCung, Long maSanPham) throws IOException {
        String uuid = UUID.randomUUID().toString();
        String filePath = FOLDER_PATH + uuid + ".jpg";
        Hinhanh hinhanh = new Hinhanh();
        hinhanh.setTenhinhanh(file.getOriginalFilename());
        hinhanh.setLoaihinhanh(file.getContentType());
        hinhanh.setTenduynhat(uuid);
        hinhanh.setPath(filePath);
        if (maNhanVien != null) {
            hinhanh.setNhanvien(nhanVienRepo.findById(maNhanVien).orElse(null));
        }
        if (maKhachHang != null) {
            hinhanh.setKhachhang(khachHangRepo.findById(maKhachHang).orElse(null));
        }
        if(maThuCung!= null){
            hinhanh.setThucung(thuCungRepo.findById(maThuCung).orElse(null));
        }
        if(maSanPham!= null){
            hinhanh.setSanpham(sanPhamRepo.findById(maSanPham).orElse(null));
        }
        hinhanh = hinhAnhRepo.save(hinhanh);

        file.transferTo(new File(filePath));

        if (hinhanh != null) {
            return "File uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(long id) throws IOException {
        Hinhanh hinhanh = new Hinhanh();
        Hinhanh fileData = hinhAnhRepo.findById(id).orElse(null);
        String filePath = fileData.getPath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}