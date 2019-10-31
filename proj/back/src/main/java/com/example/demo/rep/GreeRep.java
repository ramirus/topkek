package com.example.demo.rep;

import com.example.demo.model.Greeting;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Lazy
public interface GreeRep extends CrudRepository<Greeting, Long> {

        List<Greeting> findAll();
        Optional<Greeting> findById(Long id);
        void deleteById (Long id);
}
