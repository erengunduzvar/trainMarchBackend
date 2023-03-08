package com.example.trainMarch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "post")
public class post {
    @Id
    Long id;
    //Bir userin birden cok postu olabilir
    @ManyToOne(fetch = FetchType.LAZY)
    //user id alanını dolduracaksın
    @JoinColumn(name = "user_id",nullable = false)
    //User silinince postları da kaldır
    @OnDelete(action = OnDeleteAction.CASCADE)
    //Serilization da ignore etmek lazım
    @JsonIgnore

    user user;
    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;


}
