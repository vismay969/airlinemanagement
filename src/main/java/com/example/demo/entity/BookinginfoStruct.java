package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookinginfo")
public class BookinginfoStruct {

/*    @Column(precision = 5)
    private int flightNo ;*/

  /*  @Column(precision = 5 )
    private int userId;
*/
/*    @Column(precision = 5)
    private int flight_sch_No;*/

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingInfoGenerator")
    @SequenceGenerator(name = "bookingInfoGenerator", sequenceName = "booking_id_seq"  , allocationSize = 1)
    @Column(precision = 5)
    private int booking_id ;

    @NotNull
    @Column(length = 20,name = "flight_date")
    private LocalDateTime flightDate;

    @NotNull
    @Column(length = 30)
    private String cust_email;

    @NotNull
    @Column(length = 2)
    private int noOfPass;

    @Column(length = 20)
    private String class_type;

    private double total_fare;

    @Column(precision = 2)
    private int total_seats;

    @Column(length = 30)
    private String credit_card_info;


    @Column(length = 1,name = "status_flag")
    private String statusFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_sch_No", nullable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private FlightDetailStruct flightDetailStruct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserDetailsStruct userDetailsStruct;

    @JsonIgnore
    public FlightDetailStruct getFlightDetailStruct() {
        return flightDetailStruct;
    }

    @JsonIgnore
    public void setFlightDetailStruct(FlightDetailStruct flightDetailStruct) {
        this.flightDetailStruct = flightDetailStruct;
    }

    @JsonIgnore
    public UserDetailsStruct getUserDetailsStruct() {
        return userDetailsStruct;
    }

    @JsonIgnore
    public void setUserDetailsStruct(UserDetailsStruct userDetailsStruct) {
        this.userDetailsStruct = userDetailsStruct;
    }
}
