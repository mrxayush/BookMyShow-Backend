package com.cfs.BookMyShow.repository;

import com.cfs.BookMyShow.Model.ShowSeat;
import com.cfs.BookMyShow.Model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long>
{

List<Theater> findByScreens_Shows_Id (String city);


    List<Theater> findByCity(String city);

}
