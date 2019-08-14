package com.repository;

import com.model.Basket;
import com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {

    Optional<Basket> findFirstByUserOrderByIdDesc(User user);
}
