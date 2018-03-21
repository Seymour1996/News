package mrsj.news.serv.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/21 11:54
 * @github https://github.com/Seymour1996
 */
@Data
public class UserAction {
    private Long id;

    private Long userId;

    private Long newsId;

    private Date time;
}
