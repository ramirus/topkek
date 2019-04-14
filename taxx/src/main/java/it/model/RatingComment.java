package it.model;

import lombok.*;
import org.springframework.stereotype.Component;



@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RatingComment {
    private Long id;

    private String comment;

    private Integer ratingCount;

    private String clientPhone;
}
