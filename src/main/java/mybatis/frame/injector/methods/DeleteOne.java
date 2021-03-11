package mybatis.frame.injector.methods;

import mybatis.frame.comment.TableInfo;
import mybatis.frame.injector.AbstractMethod;
import mybatis.frame.injector.SqlMethodEnums;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/27 21:48<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
public class DeleteOne extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, TableInfo tableInfo) throws Exception {
        SqlMethodEnums sqlMethod = SqlMethodEnums.DELETE_ONE;
        //TODO:需要修改  自定义名称
        String sql = String.format(sqlMethod.getSql(),
                tableInfo.getTableName(),
                tableInfo.getPerKey().getColumnName(),
                tableInfo.getPerKey().getColumnName());
        SqlSource sqlSource = languageDriver.createSqlSource(this.configuration, sql, Object.class);
        return this.addDeleteMappedStatement(mapperClass,sqlMethod.getMethod(),sqlSource);
    }
}