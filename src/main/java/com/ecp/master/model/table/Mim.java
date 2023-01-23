package com.ecp.master.model.table;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity(name = "mims")
public class Mim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mimId;

    @Column
    private String mimName;

    @Column
    private  String mimBrand;

    @Column
    private String mimType;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/mmm/yyyy")
    private Date dateRegister = new Date();
}