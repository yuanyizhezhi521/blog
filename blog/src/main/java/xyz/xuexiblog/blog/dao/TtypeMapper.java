package xyz.xuexiblog.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.xuexiblog.blog.pojp.Ttype;
import xyz.xuexiblog.blog.util.Page;

import java.util.List;

@Mapper
public interface TtypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Ttype record);

    int insertSelective(Ttype record);

    Ttype selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Ttype record);

    int updateByPrimaryKey(Ttype record);
    List<Ttype> selectAll();
    public int selectByBlog();

    public List<Ttype> selectAllByTypeId(Page page);

    List<Ttype> selectById(Long id);

}