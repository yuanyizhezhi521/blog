package xyz.xuexiblog.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.xuexiblog.blog.pojp.Tuser;

@Mapper
public interface TuserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tuser record);
      int  insertuser(Tuser tuser);

    int insertSelective(Tuser record);

    Tuser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tuser record);

    int updateByPrimaryKeyWithBLOBs(Tuser record);

    int updateByPrimaryKey(Tuser record);
    Tuser selectByNmaeAndPwd(Tuser tuser);
    int select();
    Tuser selectByadmin (Tuser tuser);
}