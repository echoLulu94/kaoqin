package com.cxs.extension.ath.mapper;

import com.cxs.extension.ath.entity.Banner;
import com.cxs.extension.ath.entity.News;
import com.cxs.extension.ath.entity.Notify;
import com.cxs.extension.ath.entity.User;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: shylqian
 * @Description:
 * @Date: created on 上午10:50 18/3/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NotifyMapper notifyMapper;

    @Test
    public void testMyLogic() throws Exception {

        //查询用户信息
        User user = userMapper.findByPhone("18817934309");
        User user1 = userMapper.findByEnName("wuhuimin");
        //查询notify，banners, news 列表
        List<Notify> notifies = notifyMapper.selectAll();
        List<Banner> banners = bannerMapper.selectAll();
        List<News> news = newsMapper.selectAll();
        //根据用户号查询到用户信息，更新用户
        user.setPhone("123");
        userMapper.updateByPrimaryKey(user);
        System.out.println("三个接口的逻辑");
    }


}
