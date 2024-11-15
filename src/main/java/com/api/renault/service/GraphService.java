package com.api.renault.service;

import com.api.renault.models.PizzaGraphModel;
import com.api.renault.repository.PizzaGraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GraphService {
    @Autowired
    private PizzaGraphRepository pizzaGraphRepository;

    public void create(PizzaGraphModel pizzaGraphModel){
        pizzaGraphRepository.save(pizzaGraphModel);
    }
    public void delete(Integer id){
        pizzaGraphRepository.deleteById(id);
    }
    public Optional<PizzaGraphModel> findById(Integer id){
       return pizzaGraphRepository.findById(id);
    }
    public List<PizzaGraphModel> findAll(){
       return pizzaGraphRepository.findAll();
    }
}
