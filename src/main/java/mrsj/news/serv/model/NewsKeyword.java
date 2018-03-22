package mrsj.news.serv.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/21 11:55
 * @github https://github.com/Seymour1996
 */
@Data
@Entity
public class NewsKeyword {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String keyword;

    @Column
    private Long newsId;

    @Column
    private Double weight;
}
