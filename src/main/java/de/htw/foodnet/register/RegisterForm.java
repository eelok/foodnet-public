package de.htw.foodnet.register;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterForm {
    private String username;
    private String password;
    private boolean chef;
}
