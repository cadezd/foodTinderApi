package com.alergenko.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private String barcode;
    private String itemId;
    private String name;
    private String brandName;
    private String mainImageSrc;
    private String allergens;
    private String ingredients;
    private String nutritionValues;
    private String url;
}
