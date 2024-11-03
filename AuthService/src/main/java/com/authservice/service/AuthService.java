package com.authservice.service;

import com.authservice.dto.UserDetailsDto;
import com.authservice.model.UserAccountInfo;
import com.authservice.model.UserInfo;
import com.authservice.repository.AuthRepository;
import com.authservice.repository.UserAccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private UserAccountInfoRepository accountInfoRepository;

    public String createUser(UserDetailsDto userDetailsDto) {

        Optional<UserInfo> userAccountInfo = authRepository.findById(userDetailsDto.getUsername());

        if (userAccountInfo.isPresent()) {
            return "User already exists";
        }
        else {
            UserInfo userDetails= UserInfo.builder()
                    .phone(userDetailsDto.getPhone())
                    .email(userDetailsDto.getEmail())
                    .role(userDetailsDto.getRole())
                    .firstName(userDetailsDto.getFirstName())
                    .lastName(userDetailsDto.getLastName())
                    .username(userDetailsDto.getUsername())
                    .password(userDetailsDto.getPassword())
                    .build();

            UserAccountInfo userAccount=UserAccountInfo.builder()
                            .username(userDetailsDto.getUsername())
                            .password(userDetailsDto.getPassword())
                            .build();

            authRepository.save(userDetails);
            accountInfoRepository.save(userAccount);
            return "Registration successful";
        }

    }
}
