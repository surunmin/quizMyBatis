package mybatis.frame.function;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/27 17:02<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@FunctionalInterface
public interface CustomFunTwo<T> {

    T method(T t);
}