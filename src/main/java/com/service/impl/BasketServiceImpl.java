package com.service.impl;

import com.model.Basket;
import com.model.Product;
import com.model.User;
import com.repository.BasketRepository;
import com.service.BasketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    private BasketRepository basketRepository;
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    @Transactional
    public void add(Basket basket) {
        basketRepository.save(basket);
        logger.info(basket + " was added to DB");
    }

    @Override
    @Transactional
    public void addProduct(Basket basket, Product product) {
        basket.getProductList().add(product);
        basketRepository.save(basket);
        logger.info("Added " + product + " in basket " + basket);
    }

    @Override
    public int size(Basket basket) {
        return basket.getProductList().size();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Basket> getBasketByUser(User user) {
        return basketRepository.findFirstByUserOrderByIdDesc(user);
    }
}
