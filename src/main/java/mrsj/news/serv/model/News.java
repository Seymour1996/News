package mrsj.news.serv.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/21 11:28
 * @github https://github.com/Seymour1996
 */
@Data
public class News implements Serializable{
    //id
    private Long id;

    private String title;

    private String category;

    private String content;

    private String imageList;

    private String description;

    private Date time;

    private String sourceUrl;

    private String sourceSite;

    private Double score;

    private Integer reads;

    private Integer like;

    private Integer dislike;
}
