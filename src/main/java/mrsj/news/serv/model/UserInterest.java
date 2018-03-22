package mrsj.news.serv.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/21 11:52
 * @github https://github.com/Seymour1996
 */
@Data
@Entity
public class UserInterest implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private String keyword;

    @Column
    private Double weight;
}
