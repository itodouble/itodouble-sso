package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoDept;
import top.itodouble.sso.entity.sso.SsoDeptExample;
import top.itodouble.sso.mapper.sso.SsoDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： 部门service实现层</P>
 */
@Service
public class SsoDeptService {

    @Autowired
    private SsoDeptMapper ssoDeptMapper;

    public long countByExample(SsoDeptExample example){
        return ssoDeptMapper.countByExample(example);
    }

    public int deleteByExample(SsoDeptExample example){
        return ssoDeptMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoDeptMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoDept record){
        return ssoDeptMapper.insert(record);
    }

    public int insertSelective(SsoDept record){
        return ssoDeptMapper.insertSelective(record);
    }

    public List<SsoDept> selectList(SsoDept record, String orderBy) {
        return ssoDeptMapper.selectList(record, orderBy);
    }

    public List<SsoDept> selectByExample(SsoDeptExample example){
        return ssoDeptMapper.selectByExample(example);
    }

    public SsoDept selectByPrimaryKey(String id){
        return ssoDeptMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoDept record, SsoDeptExample example){
        return ssoDeptMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoDept record, SsoDeptExample example){
        return ssoDeptMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoDept record){
        return ssoDeptMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoDept record){
        return ssoDeptMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoDept> listPage(Integer pageNum, Integer pageSize, SsoDeptExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoDeptMapper.selectByExample(example));
    }

    public PageInfo<SsoDept> listPage(Integer pageNum, Integer pageSize, SsoDept record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoDeptMapper.selectList(record, orderBy));
    }
}