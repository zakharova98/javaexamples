package org.example.json;

import java.util.List;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    private String firstName;
    private String lastName;
    private List<String> children;
    private boolean married;
    private int age;
    private Address address;
    private List<String> phone_numbers;
}


