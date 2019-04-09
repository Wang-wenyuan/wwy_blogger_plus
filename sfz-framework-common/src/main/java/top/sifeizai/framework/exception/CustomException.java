package top.sifeizai.framework.exception;

import top.sifeizai.framework.model.response.ResultCode;

/**
 * Created by wwy on 2019-04-09 13:33
 * 自定义异常类
 */
public class CustomException extends RuntimeException {
    ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
