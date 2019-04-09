package top.sifeizai.framework.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by wwy on 2019-04-09 12:42
 * 此类规定了,响应提示信息,只有两种,成功和失败
 */
@Data//相当于生成了setter,getter,toString
@ToString
@NoArgsConstructor//生成有参无参构造方法
public class ResponseResult implements Response {
    //操作是否成功
    boolean success = SUCCESS;
    //操作代码
    int code = SUCCESS_CODE;
    //提示信息
    String message;
    public ResponseResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static ResponseResult SUCCESS(){
        return new ResponseResult(CommonCode.SUCCESS);
    }

    public static ResponseResult FAIL(){
        return new ResponseResult(CommonCode.FAIL);
    }
}
