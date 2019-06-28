package it.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name = "driver")
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;

    //    @Column(name = "firstname")
    private String firstname;
    //    @Column(name ="lastname")
    private String lastname;
    //    @Column(name = "hashpassword")
    private String hashPassword;
    //    @Column(name = "email")
    private String email;
    //    @Column(name = "phonenumber")
    private String phonenumber;
    //    @Column(name = "havecar")
    private String haveCar;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "driver", cascade = CascadeType.ALL)
    private Car car;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Order> orders;
}
