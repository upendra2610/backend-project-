package dev.upendra.productcatalog.inheritancerelation.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name = "jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private Long id;
    private String name;
    private String email;

}
//Created table for parent as well as for child class
//attribute of every class presents in the same class table but ONLY difference
//is all tables are connected via foreignKey with reference of User's (Parent) primary key