package com.ecp.master.model.table;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

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


}
