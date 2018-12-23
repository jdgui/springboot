package com.jundagui.service;

import com.jundagui.entity.User;

import java.util.List;

public interface IUserService {

    List<User> list(int offset, int limit);

    void logicalDelete(Long userId);

    void add(User user);

    void update(User user);

    User findByUserId(Long userId);

    Integer totalCount();

}
