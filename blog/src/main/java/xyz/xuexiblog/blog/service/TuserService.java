package xyz.xuexiblog.blog.service;

import xyz.xuexiblog.blog.pojp.Tuser;

import java.util.List;

public interface TuserService {
    int deleteByPrimaryKey(Long id);

    int insert(Tuser record);

    Tuser selectByPrimaryKey(Long id);

    List<Tuser> selectAll();

    int updateByPrimaryKey(Tuser record);

    Tuser selectByNmaeAndPwd(Tuser tuser);

    int insertuser(Tuser record);

    int select();
}
