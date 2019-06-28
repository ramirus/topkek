package it.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Component
@Lazy
public class OrderForm {
    private Long id;
    private String firstAddress;
    private String lastAddress;
    private Integer price;
    private String clientPhone;
    private String comment;
}
