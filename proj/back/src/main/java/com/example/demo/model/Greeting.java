package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "greets")
public class Greeting {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "content")
    private String content;
}
