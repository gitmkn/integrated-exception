package cn.makn;

import cn.makn.result.Result;

/**
 * 系统级异常。
 *  指系统级别的，如：网络通信时连接中断、系统连接、超时等异常
 * @Auther: makn
 * @Date: 2020/8/16 23:24
 */
public class SystemException extends BaseException{
    private Result result = new Result();

    public SystemException(Result result) {
        super(result.getErrCode()+ ":" + result.getErrMsg());
        this.result = result;
    }

    public SystemException(String code, String msg) {
        super(code + ":" + msg);
        this.result.setErrCode(code);
        this.result.setErrMsg(msg);
    }

    public SystemException(Result result, Throwable cause) {
        super(result.getErrCode() + ":" + result.getErrMsg(), cause);
        this.result = result;
    }

    public SystemException(String code, String msg, Throwable cause) {
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