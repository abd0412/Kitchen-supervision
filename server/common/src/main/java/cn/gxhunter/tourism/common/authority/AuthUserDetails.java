package cn.gxhunter.tourism.common.authority;

import lombok.Data;
import lombok.ToString;

/**
 * 权限用户详情
 *
 * @author:lujinlong
 * @created:2020-01-08 16:16
 **/
@Data
@ToString
public class AuthUserDetails {
    private String username;
    private String password;
    private String role;
    private String authorityString;
}
