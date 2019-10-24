package xyz.xuexiblog.blog.service;

import xyz.xuexiblog.blog.pojp.Tblogtags;

import java.util.List;

public interface TblogtagsService {
    int insert(Tblogtags record);

    int insertSelective(Tblogtags record);

    public int insertlist( List<Tblogtags> list);

    List<Tblogtags> selectAll();
}
