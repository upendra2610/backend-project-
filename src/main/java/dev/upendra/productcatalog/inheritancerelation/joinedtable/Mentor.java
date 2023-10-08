package dev.upendra.productcatalog.inheritancerelation.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "jt_mentor")
@PrimaryKeyJoinColumn(name = "user-id")
public class Mentor extends User{
    private double averagerating;
}
