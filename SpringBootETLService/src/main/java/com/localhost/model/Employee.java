package com.localhost.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by o.serohin on 12.07.2017.
 */
@NoArgsConstructor
public class Employee {
    @Getter @Setter private int id;
    @Getter @Setter private String firstName;
    @Getter @Setter private String secondName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String department;
    @Getter @Setter private int salary;
}
