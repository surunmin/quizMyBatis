package mybatis.frame.comment;

import lombok.Data;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.scripting.LanguageDriver;

/**
 * XML 配置属性类
 * @author zuo
 */
@Data
public class MyBatisXMLInfo {
    /**
     * 唯一标识
     */
    String id;
    /**
     * 可选 STATEMENT，PREPARED 或 CALLABLE。这会让 MyBatis 分别使用 Statement，PreparedStatement 或 CallableStatement，默认值：PREPARED。<br>
     * 定义JDBC交互方式
     */
    StatementType statementType;

    /**
     * 这是一个给驱动的建议值，尝试让驱动程序每次批量返回的结果行数等于这个设置值<br>
     * 没看懂
     */
    Integer fetchSize = 0;

    /**
     * 这个设置是在抛出异常之前，驱动程序等待数据库返回请求结果的秒数<br>
     * 异常等待时间
     */
    Integer timeout = 0;

    @Deprecated
    String parameterMap = null;
    /**
     * 将会传入这条语句的参数的类全限定名或别名<br>
     * 传入类型
     */
    Class<?> parameterType = Long.class;

    /**
     * 对外部 resultMap 的命名引用 <br>
     * 对应数据返回格式
     */
    String resultMap = null;
    /**
     * 期望从这条语句中返回结果的类全限定名或别名<br>
     * 返回类型
     */
    Class<?> resultType = String.class;

    /**
     * FORWARD_ONLY，SCROLL_SENSITIVE, SCROLL_INSENSITIVE 或 DEFAULT（等价于 unset） 中的一个<br>
     */
    ResultSetType resultSetType = null;

    /**
     * 将其设置为 true 后，只要语句被调用，都会导致本地缓存和二级缓存被清空，默认值：false。<br>
     * 查询是否清空本地缓存
     */
    boolean flushCache = false;

    /**
     * 将其设置为 true 后，将会导致本条语句的结果被二级缓存缓存起来，默认值：对 select 元素为 true。<br>
     * 查询是否禁用本地缓存
     */
    boolean useCache = true;

    /**
     * 这个设置仅针对嵌套结果 select 语句：如果为 true，将会假设包含了嵌套结果集或是分组，当返回一个主结果行时，就不会产生对前面结果集的引用。 这就使得在获取嵌套结果集的时候不至于内存不够用。默认值：false。
     */
    boolean resultOrdered = false;

    /**
     * 如果配置了数据库厂商标识（databaseIdProvider），MyBatis 会加载所有不带 databaseId 或匹配当前 databaseId 的语句；如果带和不带的语句都有，则不带的会被忽略。<br>
     */
    String databaseId;

    /**
     * 这个设置仅适用于多结果集的情况。它将列出语句执行后返回的结果集并赋予每个结果集一个名称，多个名称之间以逗号分隔。
     */
    String resultSets = null;

    LanguageDriver lang;

    KeyGenerator keyGenerator;
    /**
     * （仅适用于 insert 和 update）指定能够唯一识别对象的属性，MyBatis 会使用 getGeneratedKeys 的返回值或 insert 语句的 selectKey 子元素设置它的值，默认值：未设置（unset）。
     */
    String keyProperty = null;
    /**
     * （仅适用于 insert 和 update）指定能够唯一识别对象的属性，MyBatis 会使用 getGeneratedKeys 的返回值或 insert 语句的 selectKey 子元素设置它的值，默认值：未设置（unset）。如果生成列不止一个，可以用逗号分隔多个属性名称。
     */
    String keyColumn = null;

    /**
     * sql类型
     */
    SqlCommandType sqlCommandType;

    /**
     * 执行的sql语句
     */
    private SqlSource sqlSource;
}
