package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Table(name = "airport")
//, uniqueConstraints = @UniqueConstraint(columnNames = {"location_abbr"}, name = "PK_LOCATION_ABBR"))

public class AirportStruct {


    @Column(precision = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airportGenerator")
    @SequenceGenerator(name = "airportGenerator", sequenceName = "airport_id_seq" , allocationSize = 1)
    @Id
    private Integer airport_id;

    @Column(columnDefinition="varchar2(20)")
    private String airportName;


    @Column(columnDefinition="varchar2(10)", nullable = false , unique = true)
    private String location_abbr;

    @Column(columnDefinition="varchar2(40)")
    private String location;
/*

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DEPTABBR", nullable = false)
    private List<FlightMasterStruct> flightDeptList;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ARRABBR", nullable = false)
    private List<FlightMasterStruct> flightArrList;
*/

}
