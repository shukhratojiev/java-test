package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Harddrive extends Device {
  
    @Column(name = "harddrive_capacity")
    private Long capacity;
}
