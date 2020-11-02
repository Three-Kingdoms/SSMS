package project.subs.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface MyInfoService {
     String updateNickname(HttpSession session, Integer userId, String newNickname);
     String updatePassword(HttpSession session,Integer userId, String oldPassword, String newPassword);
}
