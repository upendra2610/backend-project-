package dev.upendra.productcatalog.inheritancerelation.singletable;

import jakarta.persistence.*;

@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
// here it creates one giant table for parent class (user)
//in this table there is one colum "dtype" which is diffrentioator type
//which is type of string so make it as integer
