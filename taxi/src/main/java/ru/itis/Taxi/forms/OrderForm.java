package ru.itis.Taxi.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderForm {
    private String startPoint;
    private String endPoint;
    private Integer price;
    private String clientNumber;
    private String comment;
}
