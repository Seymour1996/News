package mrsj.news.serv.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/21 11:28
 * @github https://github.com/Seymour1996
 */
@Data
@Entity
@Table(name = "news")
public class News implements Serializable{
    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String category;

    @Column
    @Lob
    private String content;

    @Column
    @Lob
    private String imageList;

    @Column
    private String description;

    @Column
    private Date time;

    @Column
    private String sourceUrl;

    @Column
    private String sourceSite;

    @Column
    private Double score;

    @Column
    private Integer readNum;

    @Column
    private Integer likeNum;

    @Column
    private Integer dislikeNum;

}
