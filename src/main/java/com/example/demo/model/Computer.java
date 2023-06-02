package com.example.demo.model;


import com.example.demo.enums.ComputerType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Computer extends Device {
   
    @Column(name = "computer_type")
    private ComputerType type;
}
