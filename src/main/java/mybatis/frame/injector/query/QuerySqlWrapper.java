package mybatis.frame.injector.query;

import lombok.extern.slf4j.Slf4j;
import mybatis.frame.annotations.Column;
import mybatis.frame.function.SFuntion;
import mybatis.frame.injector.query.sqlSnippet.SqlSnippet;
import mybatis.frame.injector.query.sqlSnippet.WhereSqlSnippet;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/9 22:43<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Slf4j
public class QuerySqlWrapper<T> extends AbsSqlWrapper<T, SFuntion<T, ?>, QuerySqlWrapper<T>> implements SqlWrapper {

    @Override
    public String getKeyword(SFuntion<T, ?> tsFuntion) {
        String sqlField = "";
        try {
            String implClass = tsFuntion.getImplClass();

            implClass = implClass.replace("/", ".");
            Class<?> aClass = Class.forName(implClass);
            //TODO:改
            String implMethodName = tsFuntion.getImplMethodName();
            StringBuilder methodName = new StringBuilder(implMethodName);
            methodName.delete(0, 3);
            implMethodName = methodName.toString();
            char[] chars = implMethodName.toCharArray();
            chars[0] += 32;
            Field field = aClass.getDeclaredField(String.valueOf(chars));
            Set<Annotation> annotationSet = Arrays.stream(field.getDeclaredAnnotations())
                    .filter(v -> v.annotationType().getName().equals(Column.class.getName()))
                    .collect(Collectors.toSet());
            for (Annotation annotation : annotationSet) {
                Column column = (Column) annotation;
                sqlField = column.columnName();
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        }
        return sqlField;
    }

    @Override
    public String getSqlWrapper() {
        SqlSnippetManager listManager = super.getListManager();
        StringBuilder sqlWrapper = new StringBuilder();
        this.splicingSqlWhere(listManager.getSqlWhereSnippetList(), sqlWrapper);
//        this.splicingSql(listManager.getSqlHavingSnippetList(), sqlWrapper);
        super.delList();
        return sqlWrapper.toString();
    }

    private void splicingSqlWhere(List<SqlSnippet> list, StringBuilder sb) {
        //TODO:改 如何将sql拼接在一起  where系列 用 and，group用 ，分隔
        if (!list.isEmpty()) {
            list.forEach(v -> {
                WhereSqlSnippet v1 = (WhereSqlSnippet) v;

            });
        }
    }
}