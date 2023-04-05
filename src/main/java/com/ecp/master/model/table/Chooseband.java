package com.ecp.master.model.table;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString

@Entity(name = "chooseband")
public class Chooseband {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private long bjId;

    @Column
    private long userId;

    @Column
    private long empId;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH:mm:ss MM/dd/yyyy")
    private Date eventStart;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH:mm:ss MM/dd/yyyy")
    private Date eventEnd;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH:mm:ss MM/dd/yyyy")
    private Date dateCreate = new Date();

    @Column
    private int status;

}
