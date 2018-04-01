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
    private String email;

    @Column
    private String nickname;

    @Column
    private String phone;

    @Column
    private Integer sports=0;

    @Column
    private Integer finance=0;

    @Column
    private Integer house=0;

    @Column
    private Integer home=0;

    @Column
    private Integer education=0;

    @Column
    private Integer technology=0;

    @Column
    private Integer fashion=0;

    @Column
    private Integer politics=0;

    @Column
    private Integer game=0;

    @Column
    private Integer entertainment=0;
}
