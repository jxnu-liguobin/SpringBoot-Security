package cn.edu.jxnu.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 异步
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@Slf4j
@RestController
public class AsyncController {

	@Autowired
	private MockQueue mockQueue;

	@Autowired
	private DeferredResultHolder deferredResultHolder;

	@RequestMapping("/order")
	public DeferredResult<String> order() throws Exception {
		log.info("主线程开始");

		String orderNumber = RandomStringUtils.randomNumeric(8);
		mockQueue.setPlaceOrder(orderNumber);

		DeferredResult<String> result = new DeferredResult<>();
		deferredResultHolder.getMap().put(orderNumber, result);

		return result;

		// Callable<String> result = new Callable<String>() {
		// @Override
		// public String call() throws Exception {
		// logger.info("副线程开始");
		// Thread.sleep(1000);
		// logger.info("副线程返回");
		// return "success";
		// }
		// };
	}

}
