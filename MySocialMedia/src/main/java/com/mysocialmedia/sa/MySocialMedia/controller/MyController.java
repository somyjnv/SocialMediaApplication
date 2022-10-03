package com.mysocialmedia.sa.MySocialMedia.controller;

import com.mysocialmedia.sa.MySocialMedia.entity.Group;
import com.mysocialmedia.sa.MySocialMedia.entity.Post;
import com.mysocialmedia.sa.MySocialMedia.entity.User;
import com.mysocialmedia.sa.MySocialMedia.repository.GroupRepository;
import com.mysocialmedia.sa.MySocialMedia.repository.PostRepository;
import com.mysocialmedia.sa.MySocialMedia.repository.UserRepository;
import com.mysocialmedia.sa.MySocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;
    /*
    Api to Get All the posts for a User
     */
    @GetMapping("/GetPost/{id}")
    public List<List<Post>> getPosts(@PathVariable(name = "id")String id,@RequestParam(name = "sortBy")String sortBy)
    {
        return userService.getAllPostforUser(id,sortBy);
    }
    /*
    Api so User can subscribe to any Group
     */
    @PutMapping("/subscribe/{userId}/{groupId}")
    public void userSubscribeToGroup(@PathVariable(name = "userId")String userId,@PathVariable(name = "groupId")String groupId){
        userService.userSubscribingAGroup(userId,groupId);
    }
    /*
    Api to Create A User
     */
    @PostMapping("/createUser")
    public void createUser(@RequestBody User user)
    {
       userRepository.save(user);
    }
    /*
    Api to Create A Post
     */
    @PostMapping("/CreatePost")
    public void createPost(@RequestBody Post post)
    {
        postRepository.save(post);
    }
    /*
    Api to Create A Group
     */
    @PostMapping("/CreateGroup")
    public void createGroup(@RequestBody Group group)
    {
        groupRepository.save(group);
    }

}
