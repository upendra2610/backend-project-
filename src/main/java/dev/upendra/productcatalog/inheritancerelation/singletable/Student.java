package dev.upendra.productcatalog.inheritancerelation.singletable;

import jakarta.persistence.Entity;

@Entity(name = "st_student")
public class Student extends User {
    private double psp;
    private double attendance;
}
