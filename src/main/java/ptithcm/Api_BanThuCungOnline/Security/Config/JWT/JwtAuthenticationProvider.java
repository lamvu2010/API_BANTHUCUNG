package ptithcm.Api_BanThuCungOnline.Security.Config.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ptithcm.Api_BanThuCungOnline.Entity.Taikhoan;
import ptithcm.Api_BanThuCungOnline.Services.TaiKhoanService;

import java.util.ArrayList;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private TaiKhoanService taiKhoanService;

    private static PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Taikhoan taikhoan = taiKhoanService.findBytendangnhap(username);
        if(taikhoan == null || !passwordEncoder.matches(password,taikhoan.getMatkhau())){
            throw new BadCredentialsException("Invalid username or password");
        }
        return new UsernamePasswordAuthenticationToken(taikhoan,null,new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
