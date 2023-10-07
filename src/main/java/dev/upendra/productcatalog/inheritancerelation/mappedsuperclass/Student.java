package dev.upendra.productcatalog.inheritancerelation.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name = "ms_student")
public class Student extends User {
    private double psp;
    private double attendance;
}
