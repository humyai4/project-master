package com.ecp.master.model.table;


import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.Enabled;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString

@Entity(name = "userlogs")
public class Userlog {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long ulogId;



    @Column
    private int uId;

    @Column
    private String active;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/mmm/yyyy")
    private Date dateCreate = new Date();
}
