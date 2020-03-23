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
@Table(name = "client")
@Data
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orders;
}
