package com.example.demo.service;

import com.example.demo.model.Greeting;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

public interface serv {

    Greeting getById(Long id);

    List<Greeting> getAll();

    void deleteById(Long id);
}
