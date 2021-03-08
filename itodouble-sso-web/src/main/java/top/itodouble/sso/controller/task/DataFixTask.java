package top.itodouble.sso.controller.task;

import top.itodouble.common.pojo.RestResult;
import top.itodouble.sso.controller.task.thread.DataFixTaskDeptThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task/dataFix")
public class DataFixTask {
	private static Logger logger = LoggerFactory.getLogger(DataFixTask.class);

	/**
	 * 简单修复部门信息
	 * 0 0 0 * * ? 每天凌晨0执行一次
	 * @return
	 */
	@Scheduled(cron = "0 0/15 * * * ?")
	@RequestMapping(value = "/dept")
	public RestResult dept() {
		logger.info("DataFixTask.dept()...................................start");
		DataFixTaskDeptThread.getInstance().run();
		logger.info("DataFixTask.dept()...................................end");
		return RestResult.success();
	}
}
