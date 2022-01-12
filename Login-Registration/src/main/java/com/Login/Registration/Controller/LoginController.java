package com.Login.Registration.Controller;

import com.Login.Registration.Service.LoginService;
import com.Login.Registration.common.APIResponse;
import com.Login.Registration.dto.LoginRequestDto;
import com.Login.Registration.dto.SignUpRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public void get(){
        System.out.println("Test API");
    }

    @PostMapping("/signUp")
    //public ResponseEntity<APIResponse> SignUp(@RequestBody SignUpRequestDto signUpRequestDTO ){
    public APIResponse SignUp(@RequestBody SignUpRequestDto signUpRequestDTO ){
       APIResponse apiResponse = loginService.signUp(signUpRequestDTO);
       //apiResponse.setData("Registered successfully");
       return apiResponse;
    }

    @PostMapping("/login")
   //public ResponseEntity<APIResponse> SignIn(@RequestBody LoginRequestDto loginRequestDTO ){
    public APIResponse SignIn(@RequestBody LoginRequestDto loginRequestDTO ){
        APIResponse apiResponse = loginService.login(loginRequestDTO);

//        return ResponseEntity
//                .status(apiResponse.getStatus())
//                .body(apiResponse);
        return apiResponse;
    }
}
