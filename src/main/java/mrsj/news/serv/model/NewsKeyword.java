package mrsj.news.serv.model;

import lombok.Data;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/21 11:55
 * @github https://github.com/Seymour1996
 */
@Data
public class NewsKeyword {
    private Long id;

    private String keyword;

    private Long newsId;

    private Double weight;
}
