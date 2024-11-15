package com.api.renault.repository;

import com.api.renault.models.NotificationModel;
import com.api.renault.models.PizzaGraphModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaGraphRepository extends JpaRepository<PizzaGraphModel, Integer> {

}
