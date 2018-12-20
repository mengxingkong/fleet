package com.warren.fleet.common.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class MsgResult implements Serializable {

    private static final long serialVersionUID = 8859544662202569634L;
    private String status;
    private String content;
    private String extra;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
