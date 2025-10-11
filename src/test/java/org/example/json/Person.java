package org.example.json;

import java.util.List;

import com.fasterxml.jackson.annotation.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({ "children", "married" })
public class Person {
    private String firstName;
    private String lastName;
    private List<String> children;
    private boolean married;
    private int age;
    private Address address;
    @JsonAlias({"phoneNumbers", "phone_numbers"})
    @SerializedName("phoneNumbers")
    private List<String> phone_numbers;
}


