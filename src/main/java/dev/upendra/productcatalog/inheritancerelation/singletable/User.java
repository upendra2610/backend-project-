package dev.upendra.productcatalog.inheritancerelation.singletable;

import jakarta.persistence.*;

@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "0")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
// here it creates one giant table for parent class (user)
//in this table there is one colum "dtype" which is diffrentioator type
//which is type of string so make it as integer using "discriminator"
//    if user->0
//       ta->1 , student-> 2, mentor->3
