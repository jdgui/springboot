package com.jundagui.mapper;

import com.jundagui.Application;
import com.jundagui.entity.Sex;
import com.jundagui.entity.User;
import com.jundagui.support.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {

    @Resource(name = "userMapper")
    UserMapper userMapper;

    @Test
    public void query() {
        List<User> users = userMapper.query(0, 3);
        Assert.assertNotNull(users);
        log.info("=====================query(0, 3):{}", users.toString());
    }

    @Test
    public void queryByUserId() {
        User user = userMapper.queryByUserId(154485323263853L);
        Assert.assertNotNull(user);
        log.info("=====================queryByUserId (154485323263853L): {}", user);
    }

    @Test
    public void insert() {
        log.info("insert start");
        User user = new User();
        user.setUserId(IDUtil.getUserId());
        user.setName("hhhhhh");
        user.setSex(Sex.MAIL);
        user.setAge(12);
        int i = userMapper.insert(user);
        Assert.assertTrue(i > 0);
        log.info("insert end");
    }

    @Test
    public void update() {
        log.info("update start");
        User user = new User();
        user.setUserId(154485323266004L);
        user.setName("hhhhhh");
        user.setSex(Sex.MAIL);
        user.setAge(12);
        userMapper.update(user);
        log.info("update end");
    }

    @Test
    public void logicalDelete() {
        log.info("delete start");
        int i = userMapper.logicalDelete(154485323266004L);
        Assert.assertTrue(i > 0);
        log.info("delete end");
    }

}