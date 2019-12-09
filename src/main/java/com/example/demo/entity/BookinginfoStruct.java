package com.example.demo.entity;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BookingInfo")
public class BookinginfoStruct {

/*    @Column(precision = 5)
    private int flightNo ;*/

    @Column(precision = 5 )
    private int userId;

    @Column(precision = 5)
    private int flight_sch_No;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    @Column(precision = 5)
    private int booking_id ;

    @NotNull
    @Column(length = 20)
    private Date flight_date;

    @NotNull
    @Column(length = 30)
    private String cust_email;

    @NotNull
    @Column(length = 2)
    private int noOfPass;

    @Column(precision = 1)
    private char class_type;

    private double total_fare;

    @Column(precision = 2)
    private int total_seats;

    @Column(precision = 20)
    private String credit_card_info;


    @Column(precision = 1)
    private String status_flag;


}
