package mrsj.news;

import mrsj.news.serv.dao.NewsKeywordRepository;
import mrsj.news.serv.dao.NewsRepository;
import mrsj.news.serv.model.News;
import mrsj.news.serv.model.NewsKeyword;
import mrsj.news.serv.model.UserAction;
import mrsj.news.serv.service.NewsService;
import mrsj.news.serv.service.UserActionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsApplicationTests {

	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserActionService userActionService;
	@Autowired
	private NewsKeywordRepository newsKeywordRepository;
	@Test
	public void contextLoads() {
		List<News> news =newsService.findNews("时政",1,10);
		}

	@Test
	public void testAction(){
		Sort sort = new Sort(Sort.Direction.DESC,"weight"); //创建权重降序排序
		Pageable pageable = new PageRequest(0,10,sort);
		List<NewsKeyword> newsKeywords=newsKeywordRepository.findByKeyword("乐视",pageable);
		System.out.println(newsKeywords);
	}
	}


