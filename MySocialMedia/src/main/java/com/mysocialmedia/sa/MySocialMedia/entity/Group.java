package com.mysocialmedia.sa.MySocialMedia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Mygroup")
public class Group {
    @Id
    @Column(name = "group_id", nullable = false)
    private int id;
    @Column(name="group_name")
    private String name;
    @Column(name="group_profile_pic")
    private String profile_pic;
    @ManyToMany
    @JoinColumn(name="user_id")
    private List<User> user;
    @OneToMany(mappedBy = "group")
    private List<Post> posts;

}
