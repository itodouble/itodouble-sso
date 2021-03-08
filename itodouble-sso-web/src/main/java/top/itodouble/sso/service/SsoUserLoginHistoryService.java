package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoUserLoginHistory;
import top.itodouble.sso.entity.sso.SsoUserLoginHistoryExample;
import top.itodouble.sso.mapper.sso.SsoUserLoginHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： 登录历史service实现层</P>
 */
@Service
public class SsoUserLoginHistoryService {

    @Autowired
    private SsoUserLoginHistoryMapper ssoUserLoginHistoryMapper;

    public long countByExample(SsoUserLoginHistoryExample example){
        return ssoUserLoginHistoryMapper.countByExample(example);
    }

    public int deleteByExample(SsoUserLoginHistoryExample example){
        return ssoUserLoginHistoryMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoUserLoginHistoryMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoUserLoginHistory record){
        return ssoUserLoginHistoryMapper.insert(record);
    }

    public int insertSelective(SsoUserLoginHistory record){
        return ssoUserLoginHistoryMapper.insertSelective(record);
    }

    public List<SsoUserLoginHistory> selectList(SsoUserLoginHistory record, String orderBy) {
        return ssoUserLoginHistoryMapper.selectList(record, orderBy);
    }

    public List<SsoUserLoginHistory> selectByExample(SsoUserLoginHistoryExample example){
        return ssoUserLoginHistoryMapper.selectByExample(example);
    }

    public SsoUserLoginHistory selectByPrimaryKey(String id){
        return ssoUserLoginHistoryMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoUserLoginHistory record, SsoUserLoginHistoryExample example){
        return ssoUserLoginHistoryMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoUserLoginHistory record, SsoUserLoginHistoryExample example){
        return ssoUserLoginHistoryMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoUserLoginHistory record){
        return ssoUserLoginHistoryMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoUserLoginHistory record){
        return ssoUserLoginHistoryMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoUserLoginHistory> listPage(Integer pageNum, Integer pageSize, SsoUserLoginHistoryExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoUserLoginHistoryMapper.selectByExample(example));
    }

    public PageInfo<SsoUserLoginHistory> listPage(Integer pageNum, Integer pageSize, SsoUserLoginHistory record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoUserLoginHistoryMapper.selectList(record, orderBy));
    }
}