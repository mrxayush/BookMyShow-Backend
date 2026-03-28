package com.cfs.BookMyShow.repository;

import com.cfs.BookMyShow.Model.ShowSeat;
import com.cfs.BookMyShow.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{

Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);



}
