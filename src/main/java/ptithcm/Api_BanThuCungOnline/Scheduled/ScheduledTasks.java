package ptithcm.Api_BanThuCungOnline.Scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ptithcm.Api_BanThuCungOnline.Entity.Taikhoan;
import ptithcm.Api_BanThuCungOnline.Services.TaiKhoanService;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    TaiKhoanService taiKhoanService;
    @Scheduled(cron = "0 0 24 15 * * ?")
    public void deleteAccountUnused(){
        List<Taikhoan> list = new ArrayList<>();
        list = taiKhoanService.findAll();
        for(Taikhoan taikhoan : list){
            if(taikhoan.getTrangthai() == Boolean.FALSE){
                taiKhoanService.delete(taikhoan);
            }
        }
    }
}
