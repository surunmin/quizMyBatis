package mybatis.frame;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/27 19:34<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
public class QuizXMLLanguageDriver extends XMLLanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        return super.createSqlSource(configuration, script, parameterType);
    }
}