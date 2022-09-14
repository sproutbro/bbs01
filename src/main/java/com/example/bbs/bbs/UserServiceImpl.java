package com.example.bbs.bbs;

import com.example.bbs.model.User;
import lombok.AllArgsConstructor;
import org.apache.catalina.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public int login(String userID, String userPassword) {
        String userPassword1 = userRepository.getUserPassword(userID);
        if(userPassword1 != null) {
            if(userPassword1.equals(userPassword)) {
                return 1; // 로그인 성공
            }
            return 0; // 비번틀림
        }
        return -1; // 아이디가 없음
    }

    @Override
    public int join(User user) {
        return userRepository.insertUser(user);
    }
}
