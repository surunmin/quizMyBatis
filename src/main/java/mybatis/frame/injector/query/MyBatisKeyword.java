package mybatis.frame.injector.query;

import lombok.Getter;


/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/9 21:35<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Getter
public enum MyBatisKeyword {

    EQ("=",SqlType.WHERE);

    private final String sqlField;
    private final SqlType type;

    MyBatisKeyword(String sqlField,SqlType type) {
        this.sqlField = sqlField;
        this.type = type;
    }
}
