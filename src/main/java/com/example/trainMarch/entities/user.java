package com.example.trainMarch.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data

public class user {
    @Id
    Long id;
    String userName;
    String password;
}
