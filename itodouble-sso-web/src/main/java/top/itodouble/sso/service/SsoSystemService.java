package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoSystem;
import top.itodouble.sso.entity.sso.SsoSystemExample;
import top.itodouble.sso.mapper.sso.SsoSystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： 关联系统service实现层</P>
 */
@Service
public class SsoSystemService {

    @Autowired
    private SsoSystemMapper ssoSystemMapper;

    public long countByExample(SsoSystemExample example){
        return ssoSystemMapper.countByExample(example);
    }

    public int deleteByExample(SsoSystemExample example){
        return ssoSystemMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoSystemMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoSystem record){
        return ssoSystemMapper.insert(record);
    }

    public int insertSelective(SsoSystem record){
        return ssoSystemMapper.insertSelective(record);
    }

    public List<SsoSystem> selectList(SsoSystem record, String orderBy) {
        return ssoSystemMapper.selectList(record, orderBy);
    }

    public List<SsoSystem> selectByExample(SsoSystemExample example){
        return ssoSystemMapper.selectByExample(example);
    }

    public SsoSystem selectByPrimaryKey(String id){
        return ssoSystemMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoSystem record, SsoSystemExample example){
        return ssoSystemMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoSystem record, SsoSystemExample example){
        return ssoSystemMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoSystem record){
        return ssoSystemMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoSystem record){
        return ssoSystemMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoSystem> listPage(Integer pageNum, Integer pageSize, SsoSystemExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoSystemMapper.selectByExample(example));
    }

    public PageInfo<SsoSystem> listPage(Integer pageNum, Integer pageSize, SsoSystem record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoSystemMapper.selectList(record, orderBy));
    }
}