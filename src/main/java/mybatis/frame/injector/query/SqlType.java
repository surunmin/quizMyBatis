package mybatis.frame.injector.query;

import lombok.Getter;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/9 22:40<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Getter
public enum  SqlType {
    WHERE(),HAVING(),GROUP_BY(),ORDER_BY();

}