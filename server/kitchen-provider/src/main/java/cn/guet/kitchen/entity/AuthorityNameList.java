package cn.guet.kitchen.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/10
 **/
public class AuthorityNameList {
    List<JSONObject> authorityNameList;

    public List<JSONObject> getAuthorityNameList() {
        return authorityNameList;
    }

    public void setAuthorityNameList(List<JSONObject> authorityNameList) {
        this.authorityNameList = authorityNameList;
    }
}
