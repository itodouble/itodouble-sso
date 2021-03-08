package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoArea;
import top.itodouble.sso.entity.sso.SsoAreaExample;
import top.itodouble.sso.mapper.sso.SsoAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： service实现层</P>
 */
@Service
public class SsoAreaService {

    @Autowired
    private SsoAreaMapper ssoAreaMapper;

    public long countByExample(SsoAreaExample example){
        return ssoAreaMapper.countByExample(example);
    }

    public int deleteByExample(SsoAreaExample example){
        return ssoAreaMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoAreaMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoArea record){
        return ssoAreaMapper.insert(record);
    }

    public int insertSelective(SsoArea record){
        return ssoAreaMapper.insertSelective(record);
    }

    public List<SsoArea> selectList(SsoArea record, String orderBy) {
        return ssoAreaMapper.selectList(record, orderBy);
    }

    public List<SsoArea> selectByExample(SsoAreaExample example){
        return ssoAreaMapper.selectByExample(example);
    }

    public SsoArea selectByPrimaryKey(String id){
        return ssoAreaMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoArea record, SsoAreaExample example){
        return ssoAreaMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoArea record, SsoAreaExample example){
        return ssoAreaMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoArea record){
        return ssoAreaMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoArea record){
        return ssoAreaMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoArea> listPage(Integer pageNum, Integer pageSize, SsoAreaExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoAreaMapper.selectByExample(example));
    }

    public PageInfo<SsoArea> listPage(Integer pageNum, Integer pageSize, SsoArea record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoAreaMapper.selectList(record, orderBy));
    }
}