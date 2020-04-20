package hate.hateee.mdls;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mega_table")
@Data
public class RandomString {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonProperty("id")
    private Long id;
    @Column
    @JsonProperty("random_string")
    private String random_string;
    @Column
    @JsonProperty("second_random")
    private String second_random;
}
