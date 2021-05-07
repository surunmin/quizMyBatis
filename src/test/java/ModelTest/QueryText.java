package ModelTest;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/13 15:09<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfiguration.class)
public class QueryText {

    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        return null;
    }


    public void text() {

    }
}