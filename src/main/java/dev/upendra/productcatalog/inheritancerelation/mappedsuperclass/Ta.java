package dev.upendra.productcatalog.inheritancerelation.mappedsuperclass;


import jakarta.persistence.Entity;

@Entity(name = "ms_ta")
public class Ta extends User {
    private double averagerating;
}
