package mrsj.news.serv.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/21 11:43
 * @github https://github.com/Seymour1996
 */
@Data
public class User implements Serializable{
    private Long id;

    private String username;

    private String password;

    private String macAddress;

    private Integer sports;

    private Integer finance;

    private Integer house;

    private Integer home;

    private Integer education;

    private Integer technology;

    private Integer fashion;

    private Integer politics;

    private Integer game;

    private Integer entertainment;
}
