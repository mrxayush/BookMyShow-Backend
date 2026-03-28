package com.cfs.BookMyShow.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "screen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; //audi1 , audi 2

    private Integer totalSeats;

    @ManyToOne
    @JoinColumn(name = "theater_id" , nullable = false)
    private Theater theater;

    @OneToMany(mappedBy = "screen" , cascade = CascadeType.ALL)
    private List<Show> shows;

    @OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
    private List<Seat> seats;
}
