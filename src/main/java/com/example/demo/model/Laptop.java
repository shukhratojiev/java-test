package com.example.demo.model;


import com.example.demo.enums.LaptopSize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Laptop extends Device {

    @Column(name = "laptop_size")
    private LaptopSize size;
    
}
