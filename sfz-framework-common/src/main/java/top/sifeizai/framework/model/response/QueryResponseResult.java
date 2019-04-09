package top.sifeizai.framework.model.response;

import lombok.Data;
import lombok.ToString;

/**
 * Created by wwy on 2019-04-09 12:42
 * 此类用来返回的数据有,结果集和记录数
 */
@Data
@ToString
public class QueryResponseResult<T> extends ResponseResult{
    QueryResult<T> queryResult;
    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
        this.queryResult = queryResult;
    }
}
