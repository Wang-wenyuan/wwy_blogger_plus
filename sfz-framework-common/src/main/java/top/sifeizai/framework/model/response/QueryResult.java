package top.sifeizai.framework.model.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by wwy on 2019-04-09 13:17
 */
@Data
@ToString
public class QueryResult<T> {
    //数据列表
    private List<T> list;
    //数据总数
    private long title;
}
