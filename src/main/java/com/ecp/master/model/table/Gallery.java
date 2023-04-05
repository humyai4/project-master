package com.ecp.master.model.table;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "gallery")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long galleryId;

    @Column
    private long subId;

    @Column
    private String galleryName;

    @Column
    private long userId;

    @Column
    private long bjId;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH:mm:ss dd/MM/yyyy")
    private Date dateCreate = new Date();
}
