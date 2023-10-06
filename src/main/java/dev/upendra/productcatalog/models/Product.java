package dev.upendra.productcatalog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseModel {
//    private Long id;
    private String title;
    private String description;
    private String image;
    // Product : Category
    //      1  :  1
    //      M  :  1
    //    = M  :  1
    // forignkey created on many side
    @ManyToOne
    private Category category;
    private double price;

}
