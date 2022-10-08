package com.ecp.master.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;


@Data
@ToString

@Entity(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int newsId;

    @Column
    private String newsTitle;

    @Column
    private String newsDetails;

    @Column
    private String newLink;

    @Column
    private String newsImg;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/mmm/yyyy")
    private Date dateCreate = new Date();

    @Column
    private String userID;
}
