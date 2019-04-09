package top.sifeizai.framework.exception;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sifeizai.framework.model.response.CommonCode;
import top.sifeizai.framework.model.response.ResponseResult;
import top.sifeizai.framework.model.response.ResultCode;

/**
 * Created by wwy on 2019-04-09 13:41
 * 统一异常捕获类
 */
@ControllerAdvice//控制器增强
public class ExceptionCatch {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);
    //ImmutableMap不可变map集合,配置异常类型所对应的错误代码
    private static ImmutableMap<Class<? extends Throwable>,ResultCode> EXCEPTIONS;
    //定义map的builder对象，去构建ImmutableMap
    private static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();

    /**
     * 捕获CustomException后,控制台打印错误信息,记录日志,响应到客户端
     * @param customException
     * @return
     */
    @ExceptionHandler(CustomException.class)//捕获CustomException类型的异常
    @ResponseBody//响应为json格式
    public ResponseResult customException(CustomException customException){
        //控制台打印异常信息
        customException.printStackTrace();
        //记录日志
        LOGGER.error("catch exception:{}",customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        return new ResponseResult(resultCode);
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception){
        exception.getMessage();
        LOGGER.error("catch exception:{}",exception.getMessage());
        //EXCEPTIONS没有构建,则进行构建
        if(EXCEPTIONS == null){
            EXCEPTIONS = builder.build();
        }
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if(resultCode !=null){
            return new ResponseResult(resultCode);
        }else{
            //返回99999异常
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
    }
    //添加一跳数据到不可变map集合中
    static{
        builder.put(HttpMessageNotReadableException.class,CommonCode.INVALID_PARAM);
    }
}
