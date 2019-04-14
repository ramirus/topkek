package it.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Component
@Lazy
public class RegDriverForm {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String haveCar;
}
