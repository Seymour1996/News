package mrsj.news.serv.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/21 11:43
 * @github https://github.com/Seymour1996
 */
@Data
@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String macAddress;

    @Column
    private Integer sports;

    @Column
    private Integer finance;

    @Column
    private Integer house;

    @Column
    private Integer home;

    @Column
    private Integer education;

    @Column
    private Integer technology;

    @Column
    private Integer fashion;

    @Column
    private Integer politics;

    @Column
    private Integer game;

    @Column
    private Integer entertainment;
}
