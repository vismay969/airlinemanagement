package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flightdetail")
public class FlightDetailStruct {

/*    @Column(precision = 5)
    private int flightNo ;*/

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightschnoGenerator")
    @SequenceGenerator(name = "flightschnoGenerator", sequenceName = "flight_sch_no_seq"  , allocationSize = 1)
    @Column(precision = 5)
    private int flight_sch_No ;

    @NotNull
    @Column(length = 20)
/*
    @Temporal(TemporalType.DATE)
*/
    /*@JsonFormat(pattern = "yyyy-MM-dd" , timezone = "Asia/Kolkata")*/
    private LocalDate dept_date;

    @NotNull
    @Column(length = 5)
    /*@JsonFormat(timezone = "Asia/Kolkata" )*/
    private LocalDateTime dept_time;

    @NotNull
    @Column(length = 5)
   /* @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")*/
    /*    

    @Temporal(TemporalType.DATE)
*/
    private LocalDate arr_date;

    @Column(precision = 3)
   /* @JsonFormat(timezone = "Asia/Kolkata" )*/
    private LocalDateTime arr_time;

    private double fare_first;

    @Column(precision = 3)
    private int seats_remaining_first;

    private double fare_business;

    @Column(precision = 3)
    private int seats_remaining_business;

    @Column(precision = 1, length = 1)

    private String status_flag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flightNo", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private FlightMasterStruct flightMaster;


    @OneToMany(mappedBy = "flightDetailStruct" , fetch =FetchType.LAZY )
    private List<BookinginfoStruct> bookinginfoList;

    @JsonIgnore
    public FlightMasterStruct getFlightMaster() {
        return flightMaster;
    }
    @JsonIgnore
    public void setFlightMaster(FlightMasterStruct flightMaster) {
        this.flightMaster = flightMaster;
    }

  /*  public int getFlight_sch_No() {
        return flight_sch_No;
    }

    public int getSeats_remaining_first() {
        return seats_remaining_first;
    }

    public void setSeats_remaining_first(int seats_remaining_first) {
        this.seats_remaining_first = seats_remaining_first;
    }

    public int getSeats_remaining_business() {
        return seats_remaining_business;
    }

    public void setSeats_remaining_business(int seats_remaining_business) {
        this.seats_remaining_business = seats_remaining_business;
    }
*/

}
