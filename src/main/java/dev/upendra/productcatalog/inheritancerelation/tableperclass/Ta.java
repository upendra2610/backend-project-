package dev.upendra.productcatalog.inheritancerelation.tableperclass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_ta")
public class Ta extends User{
    private double averagerating;
}
