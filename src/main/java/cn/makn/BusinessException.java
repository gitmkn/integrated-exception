package cn.makn;

import cn.makn.result.Result;

/**
 * 业务处理异常
 *  指用户输入了非法数据等业务逻辑存在的异常
 * @Auther: makn
 * @Date: 2020/8/16 23:24
 */
public class BusinessException extends BaseException {
    private Result result = new Result();

    public BusinessException(Result result) {
        super(result.getErrCode()+ ":" + result.getErrMsg());
        this.result = result;
    }

    public BusinessException(String code) {
        super(code);
    }

    public BusinessException(String code, String msg) {
        super(code + ":" + msg);
        this.result.setErrCode(code);
        this.result.setErrMsg(msg);
    }

    public BusinessException(Result result, Throwable cause) {
        super(result.getErrCode() + ":" + result.getErrMsg(), cause);
        this.result = result;
    }

    public BusinessException(String code, String msg, Throwable cause) {
        super(code + ":" + msg, cause);
        this.result.setErrCode(code);
        this.result.setErrMsg(msg);
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}