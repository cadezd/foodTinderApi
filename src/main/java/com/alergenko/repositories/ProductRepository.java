package com.alergenko.repositories;

import com.alergenko.entities.Product;
import com.alergenko.repositoriesInt.ProductRepoInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements ProductRepoInt {

    @Autowired
    private RedisTemplate<String, Product> redisTemplate;
    private HashOperations hashOperations;

    public ProductRepository(RedisTemplate<String, Product> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Product product) {
        System.out.println(product);
        this.hashOperations.put("PRODUCT", product.getBarcode(), product);
    }

    @Override
    public Product findByBarcode(String barcode) {
        Product product = (Product) this.hashOperations.get("PRODUCT", barcode);
        return product;
    }

    @Override
    public void update(Product product) {
        this.save(product);
    }

    @Override
    public void delete(String barcode) {
        this.hashOperations.delete("PRODUCT", barcode);
    }
}
