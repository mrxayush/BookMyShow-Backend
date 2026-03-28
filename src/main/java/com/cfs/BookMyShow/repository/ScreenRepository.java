package com.cfs.BookMyShow.repository;

import com.cfs.BookMyShow.Model.Payment;
import com.cfs.BookMyShow.Model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScreenRepository extends JpaRepository<Screen, Long>
{
   List<Screen> findByTheaterId(Long theaterId);

}
