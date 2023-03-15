package com.ecp.master.model.table;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString

@Entity(name = "userreport")
public class Userreport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String reportType;

    @Column
    private String userType;

    @Column
    private String comment;

    @Column
    private int userId;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/mmm/yyyy")
    private Date dateCreate = new Date();
}
