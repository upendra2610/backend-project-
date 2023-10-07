package dev.upendra.productcatalog.inheritancerelation.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_mentor")
@DiscriminatorValue(value = "3")
public class Mentor extends User {
    private double averagerating;
}
