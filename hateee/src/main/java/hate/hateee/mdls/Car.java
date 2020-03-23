package hate.hateee.mdls;


import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
@Data
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String carnumber;
    @Column
    private String color;
    @Column
    private String carname;

    @OneToOne
    @JoinColumn(name = "driverid", nullable = false)
    private Driver driver;
}
