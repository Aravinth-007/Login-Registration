package com.Login.Registration.Service;

import com.Login.Registration.Model.Users;
import com.Login.Registration.Repository.UserRepository;
import com.Login.Registration.common.APIResponse;
import com.Login.Registration.dto.LoginRequestDto;
import com.Login.Registration.dto.SignUpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public APIResponse signUp(SignUpRequestDto signUpRequestDto){
        APIResponse apiResponse=new APIResponse();
        Users userEntity = new Users();
        userEntity.setName(signUpRequestDto.getName());
        userEntity.setEmailId(signUpRequestDto.getEmailId());
        userEntity.setPassword(signUpRequestDto.getPassword());
        userRepository.save(userEntity);
        apiResponse.setData("Registered successfully");
        return apiResponse;
    }
    public APIResponse login(LoginRequestDto loginRequestDto){
        APIResponse apiResponse=new APIResponse();
        Users users=userRepository.findByEmailIdAndPassword(loginRequestDto.getEmailId(),loginRequestDto.getPassword());
        if(users == null){
            apiResponse.setData("User login failed");
        }else{
            apiResponse.setData("User logged in");
        }

        return apiResponse;
    }

}
