package com.example.bbs.bbs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    @DisplayName("정상 id pass 입력시 리턴값 1 테스트")
    void 로그인성공() {
        int result = userService.login("gildong", "123456");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("없는 아이디 입력시 리턴값 -1 테스트")
    void 없는아이디() {
        int result = userService.login("ddf", "123456");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("비번틀렸을시 리턴값 0 테스트")
    void 비번틀림() {
        int result = userService.login("gildong", "126");
        assertThat(result).isEqualTo(0);
    }
}