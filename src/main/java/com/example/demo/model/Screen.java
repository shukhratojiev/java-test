package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Screen extends Device {

    @Column(name = "screen_size")
    private Long diagonalSize;
    
}
