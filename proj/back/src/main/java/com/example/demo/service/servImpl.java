package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.rep.GreeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class servImpl implements serv {

    @Autowired
    @Lazy
    GreeRep greeRep;


    @Override
    public Greeting getById(Long id) {
        return greeRep.findById(id).get();
    }

    @Override
    public List<Greeting> getAll() {
        return greeRep.findAll();
    }

    @Override
    public void deleteById(Long id) {
        greeRep.deleteById(id);
    }
}
