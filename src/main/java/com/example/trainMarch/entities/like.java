package com.example.trainMarch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "p_like")
public class like {
    @Id
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    //post id alanını dolduracaksın
    @JoinColumn(name = "post_id",nullable = false)
    //post silinince commentleri de kaldır
    @OnDelete(action = OnDeleteAction.CASCADE)
    //Serilization da ignore etmek lazım
    @JsonIgnore

    post post;
    @ManyToOne(fetch = FetchType.LAZY)
    //user id alanını dolduracaksın
    @JoinColumn(name = "user_id",nullable = false)
    //User silinince postları da kaldır
    @OnDelete(action = OnDeleteAction.CASCADE)
    //Serilization da ignore etmek lazım
    @JsonIgnore

    user user;
}
