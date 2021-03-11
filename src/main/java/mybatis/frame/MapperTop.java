package mybatis.frame;

import mybatis.frame.injector.query.QuerySqlWrapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 一些声明信息
 * Description: 用来集中处理MyBatis中的Mapper
 *              <p>P</p>为 Pojo类
 *              <p>V</p>为主键类型
 * date: 2020/10/17 14:09<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
public interface MapperTop<P,V> {

    /**
     * 根据主键查询单个
     * @param v 主键
     * @return 查询的结果
     */
    P selectById(V v);

    Integer insertOne(P p);

    Integer updateOne(P p);

    Integer deleteOne(V v);

    List<P> selectList(@Param("sqlWrapper") QuerySqlWrapper<P> querySqlWrapper);
}