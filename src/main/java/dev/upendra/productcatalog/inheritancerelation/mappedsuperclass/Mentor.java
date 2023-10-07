package dev.upendra.productcatalog.inheritancerelation.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name = "ms_mentor")
public class Mentor extends User {
    private double averagerating;
}
