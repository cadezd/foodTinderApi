package com.alergenko.entities;

import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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
