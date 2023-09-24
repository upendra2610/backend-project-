package dev.upendra.productcatalog.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
//    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

}