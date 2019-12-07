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
@Table(name = "tstUserDetails")
//, uniqueConstraints = @UniqueConstraint(columnNames = {"location_abbr"}, name = "PK_LOCATION_ABBR"))

public class UserDetailsStruct {

    @Id
    @Column(precision = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private Integer userId;

    @Column(columnDefinition="varchar2(30)")
    private String userName;


    @Column(columnDefinition="varchar2(20)")
    private String password;

    @Column(columnDefinition="varchar2(20)")
    private String role;

    @Column(columnDefinition="varchar2(20)")
    private String mobileNo;

    @OneToMany(cascade = CascadeType.ALL , fetch =FetchType.LAZY )
    @JoinColumn(name = "userId", nullable = false)
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
