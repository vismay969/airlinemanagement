package com.example.demo.entity;


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

    // for testing  @OneToMany(cascade = CascadeType.ALL , fetch =FetchType.LAZY )
    @OneToMany
    @JoinColumn(name = "userId", nullable = false, insertable = false, updatable = false)
    private List<BookinginfoStruct> bookingInfoList;

/*

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DEPTABBR", nullable = false)
    private List<FlightMasterStruct> flightDeptList;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ARRABBR", nullable = false)
    private List<FlightMasterStruct> flightArrList;
*/
public Integer getUserId() {
    return userId;
}
    public String getUserName() {
        return userName;
    }
}
