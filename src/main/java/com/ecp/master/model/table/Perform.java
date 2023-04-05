package com.ecp.master.model.table;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString

@Entity(name = "perform")
public class Perform {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long performId;

    @Column
    private String performName;

    @Column
    private String performDescrips;

    @Column
    private long performUser;

    @Column
//    contentId
    private String performImg;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/mm/yyyy")
    private Date performDateCreate = new Date();
}
