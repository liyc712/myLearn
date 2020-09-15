package com.liyc.springboot.vo;

/**
 * @Author lyc
 * @Date 2020-9-4 10:38
 * @ClassName TestVo
 * @Description TODO
 */
public class TestVo {
    private String guid;
    private String msg;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"guid\":\"")
                .append(guid).append('\"');
        sb.append(",\"msg\":\"")
                .append(msg).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
