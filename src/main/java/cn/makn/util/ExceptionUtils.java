package cn.makn.util;

import cn.makn.BusinessException;
import cn.makn.SystemException;
import cn.makn.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常工具类
 * @Auther: makn
 * @Date: 2020/8/16 23:24
 */
public class ExceptionUtils {
    private static final Logger log = LoggerFactory.getLogger(ExceptionUtils.class);

    /**
     * 业务处理异常
     * @param errCode   异常码
     * @return
     */
    public static BusinessException businessException(String errCode) {
        return new BusinessException(createResult(errCode));
    }

    /**
     * 业务处理异常
     * @param errCode   自定义异常码
     * @param msg   自定义异常提示
     * @return
     */
    public static BusinessException businessException(String errCode, String msg) {
        return new BusinessException(createResult(errCode, msg));
    }

    /**
     * 业务处理异常
     * @param errCode   异常码
     * @param args  错误描述信息中的参数
     * @return
     */
    public static BusinessException businessException(String errCode, String... args) {
        return new BusinessException(createResult(errCode, args));
    }

    /**
     * 系统级异常
     * @param errCode   异常码
     * @return
     */
    public static SystemException systemException(String errCode) {
        return new SystemException(createResult(errCode));
    }

    /**
     * 业务处理异常
     * @param errCode   自定义异常码
     * @param msg   自定义异常提示
     * @return
     */
    public static SystemException systemException(String errCode, String msg) {
        return new SystemException(createResult(errCode, msg));
    }

    /**
     * 系统级异常
     * @param errCode   异常码
     * @param args  错误描述信息中的参数
     * @return
     */
    public static SystemException systemException(String errCode, String... args) {
        return new SystemException(createResult(errCode, args));
    }


    public static Result createResult(String errCode) {
        return new Result(errCode, getErrorMsg(errCode));
    }

    public static Result createResult(String errCode, String msg) {
        return new Result(errCode, msg);
    }

    public static Result createResult(String errCode, String[] args) {
        return new Result(errCode, getErrorMsg(errCode, args));
    }

    /**
     * 获取错误信息
     * @param errCode   错误码
     * @return
     */
    private static String getErrorMsg(String errCode) {
        return ErrorUtils.getErrorDesc(errCode);
    }

    /**
     * 获取错误信息
     * @param errCode   错误码
     * @param args  错误描述信息中的参数
     * @return
     */
    private static String getErrorMsg(String errCode, String[] args) {
        return ErrorUtils.getParseErrorDesc(errCode, args);
    }

}