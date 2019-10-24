package xyz.xuexiblog.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xuexiblog.blog.dao.TblogMapper;
import xyz.xuexiblog.blog.pojp.Tblog;
import xyz.xuexiblog.blog.service.TblogService;
import xyz.xuexiblog.blog.util.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TblogServiceImpl implements TblogService {

    @Autowired
    TblogMapper tblogMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(Tblog record) {
        return tblogMapper.insert(record);
    }

    @Override
    public int insertSelective(Tblog record) {
        return 0;
    }

    @Override
    public Tblog selectByPrimaryKey(Long id) {
        return tblogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Tblog record) {
        return tblogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Tblog record) {
        return tblogMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public List<Tblog> selectAll() {
        return tblogMapper.selectAll();
    }

    @Override
    public List<Tblog> selectAllOrText() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Tblog record) {
        return tblogMapper.updateByPrimaryKey(record);
    }


    @Override
    public int selectcount() {
        return tblogMapper.selectcount();
    }

    @Override
    public List<Tblog> selectByBlogId() {
        return tblogMapper.selectByBlogId();
    }

    @Override
    public Tblog selectByUserId(Long id) {
        return tblogMapper.selectByUserId(id);
    }

    @Override
    public Tblog selectByName(String name) {
        return tblogMapper.selectByName(name);
    }

    @Override
    public Map<String, List<Tblog>> selectordecDate() {
        String[] strings = tblogMapper.selectYer();
        List<Tblog> objects = tblogMapper.selectTime();
        Map<String, List<Tblog>> map=new HashMap<>();
        for (int i = 0; i <strings.length ; i++) {
                map.put(strings[i],objects);
        }
        return map;
    }

    @Override
    public List<Tblog> selectLikeTitle(Page tblog) {
        return tblogMapper.selecttitle(tblog);
    }

    @Override
    public List<Tblog> selectRecommend() {
        return tblogMapper.selectRecommend();
    }
}
