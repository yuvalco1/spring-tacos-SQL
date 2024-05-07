package com.example.springtacos.repositories;
import com.example.springtacos.model.Taco;
import org.springframework.data.repository.CrudRepository;
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
