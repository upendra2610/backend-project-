package dev.upendra.productcatalog.inheritancerelation.tableperclass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_mentor")
public class Mentor extends User{
    private double averagerating;
}
