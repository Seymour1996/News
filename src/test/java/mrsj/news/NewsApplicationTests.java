package mrsj.news;

import mrsj.news.serv.dao.NewsRepository;
import mrsj.news.serv.model.News;
import mrsj.news.serv.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsApplicationTests {

	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private NewsService newsService;
	@Test
	public void contextLoads() {
		List<News> news =newsService.findNews("时政",1,10);
		}
	}

