package mybatis.frame.query;



import mybatis.frame.exception.QuizMyBatisException;
import mybatis.frame.query.sqlSnippet.HavingSqlSnippet;
import mybatis.frame.query.sqlSnippet.SqlSnippet;
import mybatis.frame.query.sqlSnippet.WhereSqlSnippet;
import mybatis.frame.util.MyBatisStringPool;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/5 19:31<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@SuppressWarnings("all")
public abstract class AbsSqlWrapper<T, ColumnType, Children extends AbsSqlWrapper<T, ColumnType, Children>>
        implements WhereSqlWrapper<Children, ColumnType>,HavingSqlWrapper<Children, ColumnType> {

    public Children eq(ColumnType columnType, Object value) {
        return this.addCondition(columnType, MyBatisKeyword.EQ, value);
    }

    @Override
    public Children in(ColumnType columnType, Collection<?> value) {
        return this.addCondition(columnType,MyBatisKeyword.IN,StringUtils.join((Collection)value, MyBatisStringPool.E_COMMA.getType()));
    }

    @Override
    public Children limit(Integer start, Integer pageSize) {
        Object value = start + MyBatisStringPool.E_COMMA.getType() + pageSize;
        return this.addCondition(null,MyBatisKeyword.LIMIT,value);
    }

    @Override
    public Children like(ColumnType columnType, Object value) {
        return this.addCondition(columnType,MyBatisKeyword.LIKE,value);
    }

    @Override
    public List<SqlSnippet> getList() {
        return null;
    }

    @Override
    public void addList(SqlSnippet sqlSnippet) {

    }

    @SuppressWarnings(value = "All")
    private Children addCondition(ColumnType columnType, MyBatisKeyword keyword, Object value) {
        switch (keyword.getType()) {
            case WHERE:
                WhereSqlSnippet sqlSnippet = new WhereSqlSnippet();
                sqlSnippet.setJavaValue(value);
                sqlSnippet.setKeyword(keyword.getSqlField());
                sqlSnippet.setSqlField(this.getKeyword(columnType));
                WhereSqlWrapper.super.addList(sqlSnippet);
                break;
            case HAVING:
                HavingSqlSnippet havingSqlSnippet = new HavingSqlSnippet();
                havingSqlSnippet.setValue(value);
                havingSqlSnippet.setKeyword(keyword.getSqlField());
                HavingSqlWrapper.super.addList(havingSqlSnippet);
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