package com.projeto.CafeAromaESabor.Repository;

import com.projeto.CafeAromaESabor.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{
}
