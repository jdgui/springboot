package com.jundagui.web.controller;

import com.jundagui.entity.User;
import com.jundagui.service.IUserService;
import com.jundagui.support.IDUtil;
import com.jundagui.web.vo.PageVo;
import com.jundagui.web.vo.PageWebRequest;
import com.jundagui.web.vo.WebResponse;
import com.jundagui.web.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    IUserService userService;

    @RequestMapping(path = "/list")
    public WebResponse<PageVo<UserVo>> query(@ModelAttribute PageWebRequest pagedWebRequest) {
        log.info("query param:{}", pagedWebRequest.toString());
        Integer offset = pagedWebRequest.getOffset();
        Integer limit = pagedWebRequest.getLimit();

        List<User> users = userService.list(offset, limit);
        Integer total = userService.totalCount();
        List<UserVo> userVos = users.stream().map(UserVo::new).collect(Collectors.toList());
        PageVo<UserVo> pagedResult = new PageVo<>(total, userVos);

        log.info("query result:{}", pagedResult.toString());
        return WebResponse.success(pagedResult);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public WebResponse<Void> create(@ModelAttribute UserVo userVo) {
        log.info("create param:{}", userVo.toString());
        userVo.setUserId(IDUtil.getUserId());
        User user = userVo.toUser();
        userService.add(user);
        return WebResponse.success();

    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public WebResponse<Void> update(@ModelAttribute UserVo userVo) {
        log.info("update param:{}", userVo.toString());
        User user = userVo.toUser();
        userService.update(user);
        return WebResponse.success();
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public WebResponse<Void> delete(@RequestParam Long userId) {
        log.info("delete param:{}", userId.toString());
        userService.logicalDelete(userId);
        return WebResponse.success();
    }
}

