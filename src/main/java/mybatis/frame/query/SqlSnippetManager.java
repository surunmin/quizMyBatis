package mybatis.frame.query;

import lombok.Data;
import mybatis.frame.query.sqlSnippet.SqlSnippet;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/9 23:03<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Data
public class SqlSnippetManager {

    List<SqlSnippet> sqlWhereSnippetList;

    List<SqlSnippet> sqlHavingSnippetList;
}