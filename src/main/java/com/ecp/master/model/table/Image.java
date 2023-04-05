package com.ecp.master.model.table;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString

public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String imagesName;

    @Column
    public  int contentId;

}
