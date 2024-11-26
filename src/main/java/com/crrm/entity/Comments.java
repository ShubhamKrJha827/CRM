package com.crrm.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comments {
    @Id
    @Column(name = "id" , nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
