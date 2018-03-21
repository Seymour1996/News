package mrsj.news.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

import static mrsj.news.job.NewsCrawler.type;

public class KeywordsReceiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(KeywordsReceiver.class);

	private CountDownLatch latch;

	@Autowired
	public KeywordsReceiver(CountDownLatch latch) {
		this.latch = latch;
	}

	public void receiveMessage(String message) {
		type=message;
		latch.countDown();
	}
}
