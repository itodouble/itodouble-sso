package top.itodouble.sso.controller.common;

import top.itodouble.common.pojo.RestResult;
import top.itodouble.common.utils.JsonUtils;
import top.itodouble.common.utils.StringUtils;
import top.itodouble.sso.service.SsoUserService;
import top.itodouble.sso.service.add.SsoUserAddService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/translate")
public class TranslateController {
	private static Logger logger = LoggerFactory.getLogger(TranslateController.class);

	@Autowired
	private SsoUserAddService ssoUserAddService;
	@Autowired
	private SsoUserService ssoUserService;

	@PostMapping(value = "/user")
	public RestResult user(@RequestBody Map param) {
		logger.info(JsonUtils.beanToString(param));
		if (StringUtils.isNotNull(param.get("userIds"))) {
			String userIds = StringUtils.toString(param.get("userIds"));
			List<String> userIdList = Arrays.asList(userIds.split(","));
			return RestResult.success().data(ssoUserAddService.selectUserName(userIdList));
		}
		return RestResult.success();
	}

	@PostMapping(value = "/userSelector")
	public RestResult userSelector(@RequestBody Map param){
		logger.info(JsonUtils.beanToString(param));
		return RestResult.success().data(ssoUserAddService.selectUserListByKeyword(param));
	}
}
