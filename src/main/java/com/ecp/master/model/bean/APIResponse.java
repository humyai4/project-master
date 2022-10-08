package com.ecp.master.model.bean;


import lombok.Data;
import lombok.ToString;

@ToString
@Data


public class APIResponse {
    private int status;
    private String message;
    private Object data;
    private Object data2;
    private Object dataRole;
}
