package mybatis.frame.injector.query.sqlSnippet;

import lombok.Data;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/13 1:04<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Data
public class WhereSqlSnippet implements SqlSnippet {

    private String sqlField;

    private String keyword;

    private Object javaValue;
}