package com.nepalyatra.repositories;

import com.nepalyatra.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {



}
