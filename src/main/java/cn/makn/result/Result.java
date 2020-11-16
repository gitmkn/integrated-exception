package cn.makn.result;

import cn.makn.util.ObjectUtils;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Result implements Serializable {
    //状态码
    private String errCode;
    //提示信息
    private String errMsg;
    //结果数据
    private Object data;

    public Result() {

    }

    public Result(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 重写toString方法，让Result对象以json字符串形式存在
     * @return
     *  Json字符串
     */
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("errCode", this.errCode);
        json.put("errMsg", this.errMsg);
        if (null != this.data) {
            json.put("data", ObjectUtils.modelToMap(this.data));
        }
        return json.toJSONString();
    }

}
