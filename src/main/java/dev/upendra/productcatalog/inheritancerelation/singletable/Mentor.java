package dev.upendra.productcatalog.inheritancerelation.singletable;

import jakarta.persistence.Entity;

@Entity(name = "st_mentor")
public class Mentor extends User {
    private double averagerating;
}
