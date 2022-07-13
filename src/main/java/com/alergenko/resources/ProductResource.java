package com.alergenko.resources;

import com.alergenko.repositories.ProductRepository;
import com.alergenko.entities.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductResource {

    private ProductRepository productRepository;

    public ProductResource(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Adds new product
    @PostMapping("/add")
    public Product add(@ModelAttribute  final Product product) {
        productRepository.save(product);
        return productRepository.findByBarcode(product.getBarcode());
    }

    // Updates new product
    @PutMapping("/update")
    public Product update(@ModelAttribute final Product product) {
        productRepository.update(product);
        return productRepository.findByBarcode(product.getBarcode());
    }

    // Gets specific product
    @GetMapping("/get/{barcode}")
    public Product findByBarcode(@PathVariable("barcode") final String barcode) {
        return productRepository.findByBarcode(barcode);
    }

    // Deletes specific product
    @DeleteMapping("/delete/{barcode}")
    public String delete(@PathVariable("barcode") final String barcode) {
        productRepository.delete(barcode);
        return "OK";
    }
}
