package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tstairport")
//, uniqueConstraints = @UniqueConstraint(columnNames = {"location_abbr"}, name = "PK_LOCATION_ABBR"))

public class AirportStruct {

    @Column(precision = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private Integer airport_id;

    @Column(columnDefinition="varchar2(20)")
    private String airportName;

    @Id
    @Column(columnDefinition="varchar2(10)")
    private String location_abbr;

    @Column(columnDefinition="varchar2(40)")
    private String location;


    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DEPT_ABBR", nullable = false)
    private List<FlightMasterStruct> flightDeptList;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ARR_ABBR", nullable = false)
    private List<FlightMasterStruct> flightArrList;

}