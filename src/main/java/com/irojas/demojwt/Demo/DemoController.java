package com.irojas.demojwt.Demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irojas.demojwt.User.User;
import com.irojas.demojwt.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {
	
	@Autowired
	private UserService userService;
    
    @GetMapping(value = "demo")
    public String welcome()
    {
        return "saludos bro";
    }
    
    @GetMapping("/lista")
	public List<User> lista(){
		return userService.listaTodos();
	}
    
}
