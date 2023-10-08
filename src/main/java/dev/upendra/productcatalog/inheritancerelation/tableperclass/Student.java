package dev.upendra.productcatalog.inheritancerelation.tableperclass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_student")
public class Student extends User{
    private double psp;
    private double attendance;
}
