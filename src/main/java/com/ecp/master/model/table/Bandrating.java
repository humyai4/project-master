package com.ecp.master.model.table;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity(name = "Bandrating")
public class Bandrating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private long bjId;

    @Column
    private  long chId;

    @Column
    private int rate;

    @Column
    private long userId;

    @Column
    private long empId;
}
