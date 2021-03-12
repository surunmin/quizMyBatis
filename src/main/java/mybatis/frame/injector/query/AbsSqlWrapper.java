package mybatis.frame.injector.query;



import mybatis.frame.injector.query.sqlSnippet.SqlSnippet;
import mybatis.frame.injector.query.sqlSnippet.WhereSqlSnippet;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/5 19:31<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
public abstract class AbsSqlWrapper<T, ColumnType, Children extends AbsSqlWrapper<T, ColumnType, Children>>
        implements WhereSqlWrapper<Children, ColumnType>,HavingSqlWrapper<Children, ColumnType> {

    public Children eq(ColumnType columnType, Object value) {
        return this.addCondition(columnType, MyBatisKeyword.EQ, value);
    }

    @Override
    public List<SqlSnippet> getList() {
        return null;
    }

    @Override
    public void addList(SqlSnippet sqlSnippet) {

    }

    @SuppressWarnings(value = "All")
    private Children addCondition(ColumnType columnType, MyBatisKeyword myBatisKeyword, Object value) {
        switch (myBatisKeyword.getType()) {
            case WHERE:
                WhereSqlSnippet sqlSnippet = new WhereSqlSnippet();
                sqlSnippet.setJavaValue(value);
                sqlSnippet.setKeyword(myBatisKeyword.getSqlField());
                sqlSnippet.setSqlField(this.getKeyword(columnType));
                WhereSqlWrapper.super.addList(sqlSnippet);
                break;
            case HAVING:
//                HavingSqlWrapper.super.addList(sqlSnippet);
                break;
            case GROUP_BY:
            case ORDER_BY:
        }
        return (Children) this;
    }

    public abstract String getKeyword(ColumnType columnType);


    public SqlSnippetManager getListManager() {
        SqlSnippetManager sqlSnippetManager = new SqlSnippetManager();
        sqlSnippetManager.setSqlWhereSnippetList(WhereSqlWrapper.super.getList());
        sqlSnippetManager.setSqlHavingSnippetList(HavingSqlWrapper.super.getList());
        return sqlSnippetManager;
    }

    public void delList() {
        WhereSqlWrapper.super.delList();
        HavingSqlWrapper.super.delList();
    }
}