package mybatis.frame.annotations;

import mybatis.frame.type.SqlDataType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  mybatis 字段声明
 * Description: <br/>
 * date: 2020/10/18 13:49<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {

    /**
     * 字段名
     */
    String columnName() default "";

    /**
     * 字段类型
     */
    SqlDataType type() default SqlDataType.NULL;

    /**
     * 是否可空
     */
    String notNull() default "";

    /**
     * 字段描述
     */
    String comment() default "";

    /**
     * 长度
     */
    String length() default "";

    /**
     * 默认值
     * @return
     */
    String def() default "";
}
