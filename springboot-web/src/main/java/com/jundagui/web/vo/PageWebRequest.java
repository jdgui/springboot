package com.jundagui.web.vo;

import lombok.Data;

@Data
public class PageWebRequest {
    private Integer offset = 0;
    private Integer limit = 30;
}
