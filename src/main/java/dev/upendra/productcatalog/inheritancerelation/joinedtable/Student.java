package dev.upendra.productcatalog.inheritancerelation.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "jt_student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User{
    private double osp;
    private double attendance;

}
