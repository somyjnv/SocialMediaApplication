package com.mysocialmedia.sa.MySocialMedia.service;

import com.mysocialmedia.sa.MySocialMedia.entity.Group;
import com.mysocialmedia.sa.MySocialMedia.entity.Post;
import com.mysocialmedia.sa.MySocialMedia.entity.User;
import com.mysocialmedia.sa.MySocialMedia.repository.GroupRepository;
import com.mysocialmedia.sa.MySocialMedia.repository.PostRepository;
import com.mysocialmedia.sa.MySocialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    PostRepository postRepository;
    public List<List<Post>> getAllPostforUser(String id,String sortBy){
        Sort sort = Sort.by(sortBy).descending();
        Optional<User> user=userRepository.findById(Integer.parseInt(id));

        List<Group> groups=user.get().getGroups();

        return groups.stream().sorted().map(x->x.getPosts()).collect(Collectors.toList());
    }
    public void userSubscribingAGroup(String userId,String groupId) {
        Optional<User> user=userRepository.findById(Integer.parseInt(userId));
        Optional<Group> group=groupRepository.findById(Integer.parseInt(groupId));
        List<User> userList=group.get().getUser();
        userList.add(user.get());
        group.get().setUser(userList);
        groupRepository.save(group.get());
        List<Group> groupList=user.get().getGroups();
        groupList.add(group.get());
        user.get().setGroups(groupList);
        userRepository.save(user.get());

    }
}
