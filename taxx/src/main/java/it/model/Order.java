package it.model;

import lombok.*;
import org.springframework.stereotype.Component;

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

    private String firstAddress;

    private String lastAddress;

    private String clientPhone;

    private String comment;

    private Driver driver;
}
