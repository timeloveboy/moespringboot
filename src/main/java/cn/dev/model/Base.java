package cn.dev.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Base implements Serializable {
    Integer id;
    String name;
    Date create_time;
    String remarks;
}
