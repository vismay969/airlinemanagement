package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

/*    @Column(precision = 5)
    private int flightNo ;*/

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightschnoGenerator")
    @SequenceGenerator(name = "flightschnoGenerator", sequenceName = "flight_sch_no_seq"  , allocationSize = 1)
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
    @Temporal(TemporalType.DATE)
    private Date arr_date;

    @Column(precision = 3)
    private Timestamp arr_time;

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
}
