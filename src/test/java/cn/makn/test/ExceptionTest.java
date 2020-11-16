package cn.makn.test;

import cn.makn.BusinessException;
import cn.makn.util.ExceptionUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {
    private static final Logger log = LoggerFactory.getLogger(ExceptionTest.class);

    @Test
    public void exception(){
        List<BusinessException> businessExceptions = new ArrayList<BusinessException>();
        ExceptionTest exceptionTest = new ExceptionTest();

        // 业务报错测试
        exceptionTest.exceptionTest1(businessExceptions);

        System.out.printf(businessExceptions.toString());
    }

    public void exceptionTest1(List<BusinessException> businessExceptions){
        log.error("错误测试：9999");

        try {
            throw ExceptionUtils.businessException("EEX996");
        } catch (BusinessException businessException) {
            businessExceptions.add(businessException);
        }
    }

}
