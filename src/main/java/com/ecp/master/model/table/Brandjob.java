package com.ecp.master.model.table;


import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.Enabled;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString

@Entity(name = "brands")
public class Brandjob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String brandName;

    @Column
    private String jobPrice;

    @Column
    private int memSize;

//    //JOB MIM TABLE
//    @ManyToMany(fetch = FetchType.LAZY)
//    // creat new jointable
//    @JoinTable(name = "mimJob",
//    // jobid
//    joinColumns = @JoinColumn(name = "job_id"),
//    //mimId
//    inverseJoinColumns = @JoinColumn(name = "mim_id"))
//    private Set<Mim> mim = new HashSet<>();
//    //JOB MIM TABLE

    @Column
    private String jobType;
    //ชนิดของงาน ประจำ,แทน,ครั้ง
    @Column
    private String description;


    //ยังไม่เสร็จ
    @Column(columnDefinition = "HH.mm.ss dd/mmm/yyyy")
    private LocalDateTime startTime;

    @Column(columnDefinition = "HH.mm.ss dd/mmm/yyyy")
    private LocalDateTime endTime;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/mmm/yyyy")
    private Date dateCreate = new Date();




}
