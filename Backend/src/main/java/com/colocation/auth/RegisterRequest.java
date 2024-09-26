package com.colocation.auth;


import jakarta.persistence.Column;
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
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private Role role;
}
