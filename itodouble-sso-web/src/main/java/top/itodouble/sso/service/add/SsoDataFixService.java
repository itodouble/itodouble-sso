package top.itodouble.sso.service.add;

import top.itodouble.common.enums.YesOrNoEnum;
import top.itodouble.sso.entity.sso.SsoDept;
import top.itodouble.sso.service.SsoDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsoDataFixService {
	private static Logger logger = LoggerFactory.getLogger(SsoDataFixService.class);

	@Autowired
	private SsoDeptService ssoDeptService;

	public Boolean flushDept(String deptId){
		Boolean needUpdateFlag = false;
		SsoDept dept = ssoDeptService.selectByPrimaryKey(deptId);
		SsoDept deptParent = null;
		SsoDept deptOrg = null;
		if (null != dept.getParentDeptId()) {
			deptParent = ssoDeptService.selectByPrimaryKey(dept.getParentDeptId());
		}
		if (null != dept.getOrgId()) {
			if (dept.getOrgId().equals(dept.getParentDeptId())) {
				deptOrg = deptParent;
			} else {
				deptOrg = ssoDeptService.selectByPrimaryKey(dept.getOrgId());
			}
		}
		if (null == dept.getDelFlag()) {
			dept.setDelFlag(YesOrNoEnum.NO.getSnData());
			needUpdateFlag = true;
		}
		if (YesOrNoEnum.YES.getSnData().equals(dept.getEnableFlag())) {
			if (null != deptParent) {
				if (null != deptParent.getEnableFlag() && YesOrNoEnum.NO.getSnData().equals(deptParent.getEnableFlag())) {
					logger.error("dataFixDept needToFix deptParent.enableFlag 上级部门未启用但是该部门启用了 deptId:"+dept.getId()+", enableFlag:"+dept.getEnableFlag()+", parentDeptId:"+deptParent.getId()+", parentEnableFlag:"+deptParent.getEnableFlag());
				}
			}
			if (null!=deptOrg) {
				if (null != deptOrg.getEnableFlag() && YesOrNoEnum.NO.getSnData().equals(deptOrg.getEnableFlag())) {
					logger.error("dataFixDept needToFix deptOrg.enableFlag 公司未启用但是该部门却启用了 deptId:"+dept.getId()+", enableFlag:"+dept.getEnableFlag()+", orgId:"+deptOrg.getId()+", orgEnableFlag:"+deptOrg.getEnableFlag());
				}
			}

		}
		if (null != deptOrg && !YesOrNoEnum.YES.getSnData().equals(deptOrg.getOrgFlag())) {
			logger.error("dataFixDept needToFix dept 该部门的公司orgFlag不是公司 deptId:"+dept.getId()+", orgId:"+deptOrg.getId());
		}
		if (null != deptParent && !deptParent.equals(dept.getParentDeptCode()))  {
			logger.error("dataFixDept parentDeptCode deptId:"+deptId+", old:"+dept.getParentDeptCode()+", new:"+deptParent.getCode()+" !deptParent.equals(dept.getParentDeptCode()):"+!deptParent.equals(dept.getParentDeptCode()));
			needUpdateFlag = true;
			dept.setParentDeptCode(deptParent.getCode());
		}
		if (YesOrNoEnum.NO.getSnData().equals(dept.getOrgFlag()) && null == dept.getOrgId()) {
			logger.error("dataFixDept needToFix orgId is null deptId:"+dept.getId());
		}
		if (needUpdateFlag){
			ssoDeptService.updateByPrimaryKey(dept);
		}
		return true;
	}
}
