package project.subs.web.service;

import org.springframework.stereotype.Service;

@Service
public interface myInfoService {
     void saveNewNickname(String newNickname);
     void saveNewPassword(String newPassword);
}
