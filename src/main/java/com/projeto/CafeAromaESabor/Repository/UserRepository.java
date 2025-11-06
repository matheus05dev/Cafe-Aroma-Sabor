package com.projeto.CafeAromaESabor.Repository;

import com.projeto.CafeAromaESabor.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByUsername(String username);
}
