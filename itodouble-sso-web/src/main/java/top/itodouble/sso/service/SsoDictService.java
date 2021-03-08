package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoDict;
import top.itodouble.sso.entity.sso.SsoDictExample;
import top.itodouble.sso.mapper.sso.SsoDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： 数据字典表service实现层</P>
 */
@Service
public class SsoDictService {

    @Autowired
    private SsoDictMapper ssoDictMapper;

    public long countByExample(SsoDictExample example){
        return ssoDictMapper.countByExample(example);
    }

    public int deleteByExample(SsoDictExample example){
        return ssoDictMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoDictMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoDict record){
        return ssoDictMapper.insert(record);
    }

    public int insertSelective(SsoDict record){
        return ssoDictMapper.insertSelective(record);
    }

    public List<SsoDict> selectList(SsoDict record, String orderBy) {
        return ssoDictMapper.selectList(record, orderBy);
    }

    public List<SsoDict> selectByExample(SsoDictExample example){
        return ssoDictMapper.selectByExample(example);
    }

    public SsoDict selectByPrimaryKey(String id){
        return ssoDictMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoDict record, SsoDictExample example){
        return ssoDictMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoDict record, SsoDictExample example){
        return ssoDictMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoDict record){
        return ssoDictMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoDict record){
        return ssoDictMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoDict> listPage(Integer pageNum, Integer pageSize, SsoDictExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoDictMapper.selectByExample(example));
    }

    public PageInfo<SsoDict> listPage(Integer pageNum, Integer pageSize, SsoDict record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoDictMapper.selectList(record, orderBy));
    }
}