package com.bajtek.travelgram.boundary;

import com.bajtek.travelgram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}