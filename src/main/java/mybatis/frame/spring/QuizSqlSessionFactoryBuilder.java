package mybatis.frame.spring;

import mybatis.frame.core.QuizXMLConfigBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.Properties;

public class QuizSqlSessionFactoryBuilder extends SqlSessionFactoryBuilder {

    @Override
    public SqlSessionFactory build(Reader reader, String environment, Properties properties) {
        QuizXMLConfigBuilder quizXMLConfigBuilder = new QuizXMLConfigBuilder(reader, environment, properties);
        return build(quizXMLConfigBuilder.parse());
    }
}
