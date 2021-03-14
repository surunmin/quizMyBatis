package mybatis.frame.query.sqlSnippet;

import lombok.Data;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/13 14:29<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Data
public class HavingSqlSnippet implements SqlSnippet {

    private String keyword;

    private Object value;
}