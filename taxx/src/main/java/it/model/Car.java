package it.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "cars")
public class Car {
    @Column(name = "carname")
    private String name;
    @Column(name = "carnumber")
    private String carNumber;
    @Column(name = "color")
    private String color;
    @Id
    @GenericGenerator(strategy = "foreign", name = "generator",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "driver"))
    @GeneratedValue(generator = "generator")
    @Column(name = "driverid")
    private Long driverId;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Driver driver;
}
