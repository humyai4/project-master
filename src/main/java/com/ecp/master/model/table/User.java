package com.ecp.master.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.*;


@Data
@ToString


@Entity(name = "users")
//@SecondaryTable(name = "userlogs", pkJoinColumns = @PrimaryKeyJoinColumn(name ="ulogId"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String username;

    @Column
    private String fName;

    @Column
    private String lName;

    @Column
    private int tellNumb;

    @Column
    private String gender;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/mmm/yyyy")
    private Date dateRegister = new Date();

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_role",
//    joinColumns = @JoinColumn(name = "user_id"),
//    inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();

    @Column
    private String role;

    @Column
    private  String lineID;


}
