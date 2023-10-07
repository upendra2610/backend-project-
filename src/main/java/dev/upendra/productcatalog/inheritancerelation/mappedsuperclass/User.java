package dev.upendra.productcatalog.inheritancerelation.mappedsuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}

// in this tables are created for each child no table for parent(user)
// all attributes of parent prsent in the child table