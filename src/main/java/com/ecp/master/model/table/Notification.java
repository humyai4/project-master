package com.ecp.master.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long notiId;

    @Column
    private int userIdForm;

    @Column
    private String Descrip;

    @Column
    private int userIdTo;

    @Column
    private String link;

    @Column
    private String readstatus;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH:mm:ss MM/dd/yyyy")
    private Date dateCreate = new Date();


}
