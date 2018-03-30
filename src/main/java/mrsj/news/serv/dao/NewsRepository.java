package mrsj.news.serv.dao;

import mrsj.news.serv.model.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/22 13:54
 * @github https://github.com/Seymour1996
 */
public interface NewsRepository extends JpaRepository<News,Long> {
    List<News> findByCategory(String category, Pageable pageable);

    Optional<News> findById(Long id);
}
