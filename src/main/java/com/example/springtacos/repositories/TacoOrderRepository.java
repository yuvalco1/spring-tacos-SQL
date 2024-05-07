package com.example.springtacos.repositories;
import com.example.springtacos.model.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;


public interface TacoOrderRepository extends CrudRepository<TacoOrder,Long> {
}
