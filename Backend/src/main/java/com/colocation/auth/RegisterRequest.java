package com.colocation.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.colocation.services.*;
import com.colocation.repositories.*;
import com.colocation.models.*;
import com.colocation.config.*;
import com.colocation.auth.*;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterRequest {
    private String email;
    private String password;
    private Role role;
}
