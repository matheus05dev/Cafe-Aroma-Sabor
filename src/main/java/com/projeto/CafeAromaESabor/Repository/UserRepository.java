package com.projeto.CafeAromaESabor.Repository;

import com.projeto.CafeAromaESabor.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>
{
}
