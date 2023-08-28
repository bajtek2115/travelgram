package com.bajtek.travelgram.boundary;

import com.bajtek.travelgram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUsername(String username);

//    List<Post> findAllByOrderByCreatedDesc();
}