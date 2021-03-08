package top.itodouble.sso.mapper.sso.add;

import top.itodouble.sso.entity.sso.add.SsoDeptAdd;

import java.util.List;
import java.util.Map;

public interface SsoDeptAddMapper {
	List<SsoDeptAdd> selectList(Map param);
}
