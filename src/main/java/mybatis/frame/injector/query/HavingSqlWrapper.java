package mybatis.frame.injector.query;

import mybatis.frame.injector.query.sqlSnippet.SqlSnippet;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/9 23:00<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
public interface HavingSqlWrapper<Children,ColumnType> {

    List<SqlSnippet> sqlHavingSnippetList = new ArrayList<>();

    default List<SqlSnippet> getList() {
        return this.sqlHavingSnippetList;
    }

    default void addList(SqlSnippet sqlSnippet) {
        sqlHavingSnippetList.add(sqlSnippet);
    }

    default void delList() {
        sqlHavingSnippetList.clear();
    }


}
