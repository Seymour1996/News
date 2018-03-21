package mrsj.news.serv.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/21 11:52
 * @github https://github.com/Seymour1996
 */
@Data
public class UserInterest implements Serializable{
    private Long id;

    private Long userId;

    private String keyword;

    private Double weight;
}
