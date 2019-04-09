package top.sifeizai.framework.exception;

import top.sifeizai.framework.model.response.ResultCode;

/**
 * Created by wwy on 2019-04-09 13:37
 * 抛出异常类
 */
public class ExceptionCast {
    /**
     * 此方法可以抛出异常,
     * resultCode中封装了错误代码,是否成功,提示信息
     * @param resultCode
     */
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
