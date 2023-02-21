package com.springboot.parkinglot.repository.login;

import com.springboot.parkinglot.controller.login.LoginUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class IUserDaoTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserDao iUserDao;

    @Test
    public void saveTestUser() {

        String testEmail = "test@naver.com";

        // Role 작명규칙은 반드시 prefix로 ROLE_  을 명시해야 함!
        iUserDao.save(LoginUser.builder()
                .username("WonYong")
                .email(testEmail)
                .password(passwordEncoder.encode("test"))
                .role("ROLE_ADMIN")
                .active("1")
                .build());

        LoginUser loginUser = iUserDao.findByEmail(testEmail).orElseThrow(() -> new UsernameNotFoundException("not find"));
        // MANAGER 도 동일하게 생성하기

        assertThat(loginUser.getEmail()).isEqualTo(testEmail);
    }
}
