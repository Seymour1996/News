package mrsj.news.serv.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/21 11:54
 * @github https://github.com/Seymour1996
 */
@Data
@Entity
public class UserAction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long newsId;

    //0浏览 1喜欢 2不喜欢
    @Column
    private Integer type;

    @Column
    private Date time;

}
