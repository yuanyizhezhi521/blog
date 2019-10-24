package xyz.xuexiblog.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.xuexiblog.blog.pojp.Ttag;
import xyz.xuexiblog.blog.util.Page;

import java.util.List;

@Mapper
public interface TtagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Ttag record);

    int insertSelective(Ttag record);

    Ttag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Ttag record);

    int updateByPrimaryKey(Ttag record);
    List<Ttag> selectAll();
    int selectByBlog();
    List<Ttag> selectAllByTagId(Page page);
}