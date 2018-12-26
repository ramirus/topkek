package ru.itis.Taxi.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private Long driverId;
    private Date date;
    private Integer price;
    private String startPoint;
    private String endPoint;
    private String clientNumber;
    private String comment;
}
