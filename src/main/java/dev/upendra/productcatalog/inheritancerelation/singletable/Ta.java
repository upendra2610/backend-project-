package dev.upendra.productcatalog.inheritancerelation.singletable;


import jakarta.persistence.Entity;

@Entity(name = "st_ta")
public class Ta extends User {
    private double averagerating;
}
