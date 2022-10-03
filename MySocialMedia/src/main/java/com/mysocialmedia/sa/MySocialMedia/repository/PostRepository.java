package com.mysocialmedia.sa.MySocialMedia.repository;

import com.mysocialmedia.sa.MySocialMedia.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}
