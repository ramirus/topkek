package it.model;

import lombok.*;
import org.springframework.context.annotation.Lazy;
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
@Lazy
@Entity
@Table(name = "rating")
public class RatingComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;
    //    @Column(name = "comment")
    private String comment;
    @Column(name = "countrating")
    private Integer ratingcount;
    //    @Column(name = "clientphone")
    private String clientphone;
}
