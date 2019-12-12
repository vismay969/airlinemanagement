package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "UserDetails")
//, uniqueConstraints = @UniqueConstraint(columnNames = {"location_abbr"}, name = "PK_LOCATION_ABBR"))

public class UserDetailsStruct {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
    @SequenceGenerator(name = "userIdGenerator", sequenceName = "userid_seq"  , allocationSize = 1)
    @Column(precision = 5)
    private Integer userId;

    @Column(columnDefinition="varchar2(30)", unique = true)
    private String userName;


    @Column(columnDefinition="varchar2(20)")
    private String password;

    @Column(columnDefinition="varchar2(20)")
    private String role;

    @Column(columnDefinition="varchar2(20)")
    private String mobileNo;

    // for testing  @OneToMany(cascade = CascadeType.ALL , fetch =FetchType.LAZY )
    @OneToMany(mappedBy = "userDetailsStruct" ,fetch=FetchType.LAZY)
    private List<BookinginfoStruct> bookingInfoList;

/*

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DEPTABBR", nullable = false)
    private List<FlightMasterStruct> flightDeptList;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ARRABBR", nullable = false)
    private List<FlightMasterStruct> flightArrList;
*/


}
