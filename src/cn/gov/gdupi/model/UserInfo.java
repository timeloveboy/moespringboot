package cn.gov.gdupi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {
    Integer id;
    String name;
    Date create_time;
    String remarks;
    Boolean del_flag;


    String role;
}
