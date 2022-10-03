package com.mysocialmedia.sa.MySocialMedia.repository;

import com.mysocialmedia.sa.MySocialMedia.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
}
