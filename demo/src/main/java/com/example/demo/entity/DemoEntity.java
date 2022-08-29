package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

//Just for the sake of having it (Yeah, should be a DTO or model)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoEntity {
    private int number;
}
