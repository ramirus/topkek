package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Greeting;
import com.example.demo.service.serv;
import com.example.demo.service.servImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "greeting", description = "Greeting controller")
public class GreetingController {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    @Lazy
    servImpl serv;


    @ApiOperation(value = "List of greetings", response = List.class)
    @GetMapping("/greeting")
    public List<Greeting> greeting() {
        List list= new ArrayList();
        list.add(new Greeting(1L,"sdf"));
        list.add(new Greeting(2L,"sdfdg"));
        return list;
    }

    @ApiOperation(value = "Get one of greetings", response = Greeting.class)
    @GetMapping("/greeting/{id}")
    public Greeting d(@PathVariable String id) {
        return serv.getById(Long.parseLong(id));
    }

    @PostMapping("/greeting")
    @ApiOperation(value = "Add new greeting")
    public void aVoid(@RequestBody String data) throws IOException {
        Greeting g = objectMapper.readValue(data, Greeting.class);
        System.out.println(g.getContent());
        System.out.println(data);
    }

    @ApiOperation(value = "Update greeting")
    @PutMapping("/greeting")
    public void update(@RequestBody String data) throws IOException {
        Greeting g = objectMapper.readValue(data, Greeting.class);
        System.out.println("put " + g.getContent());
    }

    @ApiOperation(value = "Delete greeting by id")
    @DeleteMapping("/greeting")
    public void delete(@RequestBody String data) throws IOException {
        System.out.println(data);
        Greeting g = objectMapper.readValue(data, Greeting.class);
        System.out.println("delete " + g.getContent());
        serv.deleteById(g.getId());
    }
}
