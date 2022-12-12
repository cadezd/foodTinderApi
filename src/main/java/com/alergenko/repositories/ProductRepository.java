package com.alergenko.repositories;

import com.alergenko.entities.Product;
import com.alergenko.repositoriesInt.ProductRepoInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements ProductRepoInt {

    @Autowired
    private RedisTemplate<String, Product> redisTemplate;
    private HashOperations hashOperations;

    public ProductRepository(RedisTemplate<String, Product> redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Product product) {
        this.hashOperations.put("PRODUCT", product.getBarcode(), product);
    }

    @Override
    public Product findByBarcode(String barcode) {
        Product product = (Product) this.hashOperations.get("PRODUCT", barcode);
        return product;
    }

    @Override
    public Product getRandomProduct() {
        Product product = (Product) this.hashOperations.get("PRODUCT", hashOperations.randomKey("PRODUCT"));
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
