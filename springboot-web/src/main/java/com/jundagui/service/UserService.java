package com.jundagui.service;

import com.jundagui.entity.User;
import com.jundagui.mapper.UserMapper;
import com.jundagui.support.IDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service("userService")
public class UserService implements IUserService {

    @Resource(name = "userMapper")
    UserMapper userMapper;

    @Override
    public List<User> list(int offset, int limit) {
        return userMapper.query(offset, limit);
    }

    @Override
    public User findByUserId(Long userId) {
        return userMapper.queryByUserId(userId);
    }

    @Override
    public Integer totalCount() {
        Integer count = userMapper.totalCount();
        Objects.requireNonNull(count, "failed to count all user");
        return count;
    }

    @Override
    @Transactional
    public void add(User user) {
        check(user);
        if (userMapper.insert(user) != 1) {
            throw new IllegalStateException("failed to add user: " + user);
        }
    }

    @Override
    @Transactional
    public void logicalDelete(Long userId) {
        if (userMapper.logicalDelete(userId) != 1) {
            throw new IllegalStateException("Failed to delete user: " + userId);
        }
    }

    @Override
    @Transactional
    public void update(User user) {
        check(user);
        if (userMapper.update(user) != 1) {
            throw new IllegalStateException("failed to update user: " + user);
        }
    }

    private void check(User user) {
        Objects.requireNonNull(user, "user cannot be null");
        Objects.requireNonNull(user.getUserId(), "user's id cannot be null");
        Objects.requireNonNull(user.getName(), "user's name cannot be null");
        if (user.getName().isEmpty()) {
            throw new IllegalArgumentException("user's name cannot be empty");
        }
        Objects.requireNonNull(user.getAge(), "user's age cannot be null");
        if (user.getAge() < 0) {
            throw new IllegalArgumentException("user's age cannot negative");
        }
        if (user.getAge() > 150) {
            throw new IllegalArgumentException("user's age cannot be more than 150");
        }
    }
}
