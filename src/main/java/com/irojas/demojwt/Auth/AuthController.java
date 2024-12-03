package com.irojas.demojwt.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.irojas.demojwt.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
	@Autowired
	private UserService userService;
    
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
    
    @GetMapping("/buscarPorUsername/{username}")
   	@ResponseBody
   	public String buscarPorUsername(@PathVariable String username){
   		return userService.buscarPorUsername(username);
   	}
   	
   	@GetMapping("/buscarPorDniusua/{dni}")
   	@ResponseBody
   	public String buscarPorDni(@PathVariable String dni){
   		return userService.buscarPorDni(dni);
   	}
   	
   	@GetMapping("/buscarPorEmail/{email}")
   	@ResponseBody
   	public String buscarPorEmail(@PathVariable String email){
   		return userService.buscarPorEmail(email);
   	}
}
