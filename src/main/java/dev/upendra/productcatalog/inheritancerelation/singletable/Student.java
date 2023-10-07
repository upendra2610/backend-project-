package dev.upendra.productcatalog.inheritancerelation.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_student")
@DiscriminatorValue(value = "2")
public class Student extends User {
    private double psp;
    private double attendance;
}
