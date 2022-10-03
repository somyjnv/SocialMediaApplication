package com.mysocialmedia.sa.MySocialMedia.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "profile_pic_url")
    private String profile_pic_url;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    @ManyToMany(mappedBy = "user")
    private List<Group> groups;
}
