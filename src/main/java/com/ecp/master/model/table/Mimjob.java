package com.ecp.master.model.table;


import lombok.Data;
import lombok.ToString;
import lombok.extern.java.Log;

import javax.persistence.*;

@Data
@ToString

@Entity(name = "mimJob")
public class Mimjob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private long jobId;

    @Column
    private long mimId;
 }
