package top.sifeizai.framework.model.response;

/**
 * Created by wwy on 2019-04-09 12:00
 */
public interface ResultCode {
    //操作是否成功,true成功,false失败
    boolean success();
    //操作提示代码
    int code();
    //操纵提示信息
    String message();
}
