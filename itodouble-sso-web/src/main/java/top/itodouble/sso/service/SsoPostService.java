package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoPost;
import top.itodouble.sso.entity.sso.SsoPostExample;
import top.itodouble.sso.mapper.sso.SsoPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： 岗位service实现层</P>
 */
@Service
public class SsoPostService {

    @Autowired
    private SsoPostMapper ssoPostMapper;

    public long countByExample(SsoPostExample example){
        return ssoPostMapper.countByExample(example);
    }

    public int deleteByExample(SsoPostExample example){
        return ssoPostMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoPostMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoPost record){
        return ssoPostMapper.insert(record);
    }

    public int insertSelective(SsoPost record){
        return ssoPostMapper.insertSelective(record);
    }

    public List<SsoPost> selectList(SsoPost record, String orderBy) {
        return ssoPostMapper.selectList(record, orderBy);
    }

    public List<SsoPost> selectByExample(SsoPostExample example){
        return ssoPostMapper.selectByExample(example);
    }

    public SsoPost selectByPrimaryKey(String id){
        return ssoPostMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoPost record, SsoPostExample example){
        return ssoPostMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoPost record, SsoPostExample example){
        return ssoPostMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoPost record){
        return ssoPostMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoPost record){
        return ssoPostMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoPost> listPage(Integer pageNum, Integer pageSize, SsoPostExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoPostMapper.selectByExample(example));
    }

    public PageInfo<SsoPost> listPage(Integer pageNum, Integer pageSize, SsoPost record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoPostMapper.selectList(record, orderBy));
    }
}