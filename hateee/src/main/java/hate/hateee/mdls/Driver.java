package hate.hateee.mdls;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "driver")
@Data
public class Driver {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String firstname;
    @Column
    private String email;
    @Column
    private String lastname;
    @Column
    private String phonenumber;
    @Column
    private String havecar;
    @Column
    private String hashpassword;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Order> orders;
}
