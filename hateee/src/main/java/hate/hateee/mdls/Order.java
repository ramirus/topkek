package hate.hateee.mdls;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String comments;
    @Column
    private String firstaddress;
    @Column
    private String lastaddress;
    @Column
    private Integer price;
    @Column
    private Timestamp orderdate;
    @Column
    private String status;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "driverid", nullable = false)
    @JsonIgnore
    private Driver driver;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "clientid", nullable = false)
    @JsonIgnore
    private Client client;

    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "order_item",
            joinColumns = {@JoinColumn(name = "orderid")},
            inverseJoinColumns = {@JoinColumn(name = "itemid")})
    private List<Items> items;
}
