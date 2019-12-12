package com.example.demo.entity;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tstflightmaster")
public class FlightMasterStruct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightNoGenerator")
    @SequenceGenerator(name = "flightNoGenerator", sequenceName = "TSTFLIGHTNO_SEQ1")
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

   // @OneToMany(cascade = CascadeType.ALL , fetch =FetchType.LAZY )
    @OneToMany(mappedBy = "flightMaster" ,fetch=FetchType.LAZY)
    /*@JoinColumn(name = "flightNo", nullable = false)*/
    private List<FlightDetailStruct> flightDetailList;


}
