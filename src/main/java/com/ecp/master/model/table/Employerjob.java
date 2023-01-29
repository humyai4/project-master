package com.ecp.master.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString

@Entity(name = "employerjob")
public class Employerjob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String ejName;

    @Column
    private String description;

    //จำนวนสมาชิกจาก
    @Column
    private int memStart;

    //จำนวนสมาชิกถึง
    @Column
    private int memEnd;

    //ต่าจ้างเริ่ม
    @Column
    private int wagesStart;

    //ค่าจ้างถึง
    @Column
    private int wagesEnd;

    @Column
    private int userCreateId;

    //    @Column(columnDefinition = "HH.mm.ss dd/mmm/yyyy")
    //    private LocalDateTime scheduleStart;
    //
    //    @Column(columnDefinition = "HH.mm.ss dd/mmm/yyyy")
    //    private LocalDateTime scheduleEnd;

    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/mmm/yyyy")
    private Date dateCreate = new Date();



//    geter seter

    public String getEjName() {
        return ejName;
    }

    public void setEjName(String ejName) {
        this.ejName = ejName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMemStart() {
        return memStart;
    }

    public void setMemStart(int memStart) {
        this.memStart = memStart;
    }

    public int getMemEnd() {
        return memEnd;
    }

    public void setMemEnd(int memEnd) {
        this.memEnd = memEnd;
    }

    public int getWagesStart() {
        return wagesStart;
    }

    public void setWagesStart(int wagesStart) {
        this.wagesStart = wagesStart;
    }

    public int getWagesEnd() {
        return wagesEnd;
    }

    public void setWagesEnd(int wagesEnd) {
        this.wagesEnd = wagesEnd;
    }

    public int getUserCreateId() {
        return userCreateId;
    }

    public void setUserCreateId(int userCreateId) {
        this.userCreateId = userCreateId;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
