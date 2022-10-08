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


    public void setId(int id){
        this.id = id;
    }
    public  int getId(){
        return id; }

    public String getImageName() {
        return imagesName;
    }
    public  void  setImageName(String imagesName){
        this.imagesName = imagesName;
    }
}
