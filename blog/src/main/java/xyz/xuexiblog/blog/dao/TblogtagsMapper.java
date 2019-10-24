package xyz.xuexiblog.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.xuexiblog.blog.pojp.Tblogtags;

import java.util.List;

@Mapper
public interface TblogtagsMapper {
    int insert(Tblogtags record);

    int insertSelective(Tblogtags record);

    public int insertlist( List<Tblogtags> list);

    List<Tblogtags> selectAll();
}