package mrsj.news.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

import static mrsj.news.job.NewsCrawler.type;

public class Receiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	private CountDownLatch latch;

	@Autowired
	public Receiver(CountDownLatch latch) {
		this.latch = latch;
	}

	public void receiveMessage(String message) {
		type=message;
		latch.countDown();
	}
}
