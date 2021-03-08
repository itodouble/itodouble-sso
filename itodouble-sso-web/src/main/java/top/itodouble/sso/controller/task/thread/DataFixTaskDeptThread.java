package top.itodouble.sso.controller.task.thread;

import top.itodouble.sso.config.SpringBeanContext;
import top.itodouble.sso.entity.sso.SsoDept;
import top.itodouble.sso.service.SsoDeptService;
import top.itodouble.sso.service.add.SsoDataFixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataFixTaskDeptThread implements Runnable{
	private static Logger logger = LoggerFactory.getLogger(DataFixTaskDeptThread.class);
	@Autowired
	private SsoDataFixService ssoDataFixService;
	@Autowired
	private SsoDeptService ssoDeptService;

	private DataFixTaskDeptThread(){}
	private static class DataFixTaskDeptThreadHolder {
		public static DataFixTaskDeptThread thread = new DataFixTaskDeptThread();
	}
	public static DataFixTaskDeptThread getInstance(){
		return DataFixTaskDeptThreadHolder.thread;
	}

	@Override
	public void run() {
		logger.error("DataFixTaskDept_start............................................");
		ssoDataFixService = SpringBeanContext.getBean(SsoDataFixService.class);
		ssoDeptService = SpringBeanContext.getBean(SsoDeptService.class);
		List<SsoDept> deptList = ssoDeptService.selectByExample(null);
		deptList.forEach(each->{
			ssoDataFixService.flushDept(each.getId());
		});
		logger.error("DataFixTaskDept_end............................................");
	}
}
