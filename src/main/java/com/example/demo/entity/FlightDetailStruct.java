package com.example.demo.entity;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flightdetail")
public class FlightDetailStruct {

   @Column(precision = 5)
    private int flightNo ;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    @Column(precision = 5)
    private int flight_sch_No ;

    @NotNull
    @Column(length = 20)
    @Temporal(TemporalType.DATE)
    private Date dept_date;

    @NotNull
    @Column(length = 5)
    private Timestamp dept_time;

    @NotNull
    @Column(length = 5)
    private Date arr_date;

    @Column(precision = 3)
    private Timestamp arr_time;

    private double fare_first;

    @Column(precision = 3)
    private int seats_booked_first;

    private double fare_business;

    @Column(precision = 3)
    private int seats_booked_business;

    @Column(precision = 1)
    private String status_flag;

   // for testing @OneToMany(cascade = CascadeType.ALL , fetch =FetchType.LAZY )
    @OneToMany
    @JoinColumn(name = "flight_sch_No", nullable = false, insertable = false, updatable = false)
    private List<BookinginfoStruct> bookinginfoList;


    public void setFlightMaster(FlightMasterStruct flightMaster) {
    }
}
