package xyz.xuexiblog.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xuexiblog.blog.dao.TblogtagsMapper;
import xyz.xuexiblog.blog.pojp.Tblogtags;
import xyz.xuexiblog.blog.service.TblogtagsService;

import java.util.List;
@Service
public class TblogtagsServiceImpl implements TblogtagsService {
    @Autowired
    TblogtagsMapper tblogtagsMapper;
    @Override
    public int insert(Tblogtags record) {
        return tblogtagsMapper.insert(record);
    }

    @Override
    public int insertSelective(Tblogtags record) {
        return tblogtagsMapper.insert(record);
    }

    @Override
    public int insertlist( List<Tblogtags> list) {
        return tblogtagsMapper.insertlist( list);
    }


    @Override
    public List<Tblogtags> selectAll() {
        return tblogtagsMapper.selectAll();
    }
}
