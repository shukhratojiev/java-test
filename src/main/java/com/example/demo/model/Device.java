package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@JsonTypeInfo(
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "deviceType",
    use = JsonTypeInfo.Id.NAME,
    visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Laptop.class, name = "laptop"),
    @JsonSubTypes.Type(value = Computer.class, name = "computer"),
    @JsonSubTypes.Type(value = Screen.class, name = "screen"),
    @JsonSubTypes.Type(value = Harddrive.class, name = "harddrive")
})
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "price")
    private Double price;

    @Column(name = "number_of_items")
    private Integer numberOfItems;

    @Column(name = "device_type")
    private String deviceType; 
}
