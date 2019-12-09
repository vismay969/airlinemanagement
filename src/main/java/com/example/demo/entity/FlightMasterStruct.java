package com.example.demo.entity;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flightmaster")
public class FlightMasterStruct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    @Column(precision = 5)
    private int flightNo ;

    @NotNull
    @Column(length = 20)
    private String airline;

    @NotNull
    @Column(length = 5)
    private String dept_abbr;

    @NotNull
    @Column(length = 5)
    private String arr_abbr;

    @Column(precision = 3)
    private int noOfSeats_first;

    @Column(precision = 3)
    private int noOfSeats_business;


    // for testing  @OneToMany(cascade = CascadeType.ALL , fetch =FetchType.LAZY )
    @OneToMany
    @JoinColumn(name = "flightNo", nullable = false,insertable = false,updatable = false)
    private List<FlightDetailStruct> flightDetailList;


}
