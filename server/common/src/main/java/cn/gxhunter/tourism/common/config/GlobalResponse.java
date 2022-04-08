package cn.gxhunter.tourism.common.config;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 通用的数据返回对象
 * @param <T>
 */
@Data
@ToString
public class GlobalResponse<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public final static Integer SUCCESS_CODE = 200;
    public final static Integer LOGIN_FAIL_CODE = 401;
    public final static Integer AUTH_FAIL_CODE = 403;
    public final static Integer COMMON_ERROR = 500;
    public final static String LOGIN_FAIL_MESSAGE ="身份验证失败，请确认是否已正确登录！";
    public final static String AUTH_FAIL_MESSAGE ="没有访问该接口的权限";

    public GlobalResponse(T data){
        this.data = data;
    }

    public static <T> GlobalResponse<T> success(T data){
        GlobalResponse<T> res = new GlobalResponse(data);
        res.setCode(SUCCESS_CODE);
        return res;
    }

    public static <T> GlobalResponse<T> loginFail(String errorMsg){
        GlobalResponse<T> res =  new GlobalResponse(null);
        res.setCode(LOGIN_FAIL_CODE);
        res.setMessage(errorMsg);
        return res;
    }

    public static <T> GlobalResponse<T> authFail(String errorMsg){
        GlobalResponse<T> res =  new GlobalResponse(null);
        res.setCode(AUTH_FAIL_CODE);
        res.setMessage(errorMsg);
        return res;
    }

    public static <T> GlobalResponse<T> error(String errorMsg){
        GlobalResponse<T> res =  new GlobalResponse(null);
        res.setCode(COMMON_ERROR);
        res.setMessage(errorMsg);
        return res;
    }
    public static <T> GlobalResponse<T> error(String errorMsg, Integer errCode){
        GlobalResponse<T> res =  new GlobalResponse(null);
        res.setCode(errCode);
        res.setMessage(errorMsg);
        return res;
    }
}
