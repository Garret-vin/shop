package com.service.impl;

import com.model.Product;
import com.repository.ProductRepository;
import com.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void add(Product product) {
        productRepository.save(product);
        logger.info(product + " was added to DB");
    }

    @Override
    @Transactional
    public void remove(Long id) {
        productRepository.deleteById(id);
        logger.info("Product " + id + " was deleted from DB");
    }

    @Override
    @Transactional
    public void update(Product product) {
        productRepository.save(product);
        logger.info(product + " was updated in DB");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }
}
