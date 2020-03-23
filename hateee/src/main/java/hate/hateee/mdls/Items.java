package hate.hateee.mdls;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
@Data
public class Items {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private Integer price;
    @Column
    private Integer count;

    @ManyToMany(mappedBy = "items", cascade = CascadeType.ALL)
    private List<Order> orders ;
}
