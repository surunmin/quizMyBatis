package mybatis.frame.injector.query;

import lombok.Data;

/**
 * sql片段存储
 * Description: <br/>
 * date: 2021/3/9 21:41<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Data
public class SqlSnippet {

    private String sqlField;

    private String keyword;

    private Object javaValue;
}