package ru.itis.Taxi.models;

import lombok.*;

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
