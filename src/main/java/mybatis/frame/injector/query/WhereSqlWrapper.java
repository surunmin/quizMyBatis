package mybatis.frame.injector.query;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/5 19:24<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
public interface WhereSqlWrapper<Children,ColumnType> {

    List<SqlSnippet> sqlWhereSnippetList = new ArrayList<>();

    Children eq(ColumnType columnType, Object value) ;

    default List<SqlSnippet> getList() {
        return this.sqlWhereSnippetList;
    }

    default void addList(SqlSnippet sqlSnippet) {
        sqlWhereSnippetList.add(sqlSnippet);
    }

    default void delList() {
        sqlWhereSnippetList.clear();
    }
}