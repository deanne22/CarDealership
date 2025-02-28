package com.example.CarDealer.Controllers;

import com.example.CarDealer.Models.UserModel;
import com.example.CarDealer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/signUp")
    public ResponseEntity<Map<String,String>> signUp(@RequestBody UserModel user){
        UserModel userObj = userRepo.save(user);

        Map<String,String> response = new HashMap<>();

        if(userObj.getUserid() != 0){
            response.put("Status","Signup success");
            response.put("User id",String.valueOf(userObj.getUserid()));
            response.put("Name",String.valueOf(userObj.getName()));

        }
        else{
            response.put("Status","Signup failed!");
        }
        return ResponseEntity.ok(response);
    }
    @PostMapping("/signIn")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody UserModel user){
        List<UserModel> userObj = userRepo.loginValidation(user.getEmail(),user.getPassword());

        Map<String,String> response = new HashMap<>();

        if(userObj.size() > 0){
            response.put("Status","Sign in success");
            response.put("User Id",String.valueOf(userObj.get(0).getUserid()));
            response.put("Name",String.valueOf(userObj.get(0).getName()));
        }
        else{
            response.put("Status","Sign in failed");
        }
        return ResponseEntity.ok(response);
    }
}
