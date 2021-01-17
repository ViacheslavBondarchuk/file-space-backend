package hbv.com.ua.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    private Long id;
    private String firstname;
    private String lastname;
    private String middlename;
    private String phone;
    private String email;
    private Set<Vehicle> vehicles;
}
