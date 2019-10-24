package xyz.xuexiblog.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xuexiblog.blog.dao.TuserMapper;
import xyz.xuexiblog.blog.pojp.Tuser;
import xyz.xuexiblog.blog.service.TuserService;

import java.util.List;
@Service
public class TuserServiceImpl implements TuserService {

    @Autowired
    TuserMapper tuserMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(Tuser record) {
        int insert = tuserMapper.insert(record);
        return insert;
    }

    @Override
    public Tuser selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<Tuser> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Tuser record) {
        return 0;
    }

    @Override
    public Tuser selectByNmaeAndPwd(Tuser tuser) {
        return tuserMapper.selectByNmaeAndPwd(tuser);
    }

    @Override
    public int insertuser(Tuser record) {
        int insert = tuserMapper.insertuser(record);
        return insert;
    }

    @Override
    public int select() {
        return  tuserMapper.select();
    }
}
