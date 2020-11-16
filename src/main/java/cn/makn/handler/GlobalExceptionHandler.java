package cn.makn.handler;

import cn.makn.BusinessException;
import cn.makn.SystemException;
import cn.makn.result.Result;
import cn.makn.util.ExceptionUtils;
//import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 全局异常捕获处理
 * @Auther: makn
 * @Date: 2020/8/16 15:19
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 业务逻辑异常。
     *  HTTP响应状态为200
     * @param businessException
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity businessExceptionHandler(BusinessException businessException) {
        Result result = businessException.getResult();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 系统异常。
     *  HTTP响应状态为400
     * @param systemException
     * @return
     */
    @ExceptionHandler(value = SystemException.class)
    public ResponseEntity systemExceptionHandler(SystemException systemException) {
        Result result = systemException.getResult();
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }



    /**
     * 系统其他意外异常。
     *  HTTP响应状态为400
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exceptionHandle(Exception e){
        e.printStackTrace();
        if(log.isErrorEnabled()){
            log.error("系统异常--{}", e.getMessage());
        }
        Result result = null;
        if(e instanceof RuntimeException){
            if(e instanceof SQLException){
                result = ExceptionUtils.createResult("EEX997");
//            }else if(e instanceof BadSqlGrammarException) {
//                result = ExceptionUtils.createResult("EEX998");
            }else{
                result = ExceptionUtils.createResult("EEX999");
            }
        }else if(e instanceof IOException){
            result = ExceptionUtils.createResult("EEX996");
        }else{
            result = ExceptionUtils.createResult("EEX999");

        }
        result.setData("F");
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

}