package mybatis.frame.config.idConfig;

/**
 * Id生成器
 * Description: <br/>
 * date: 2020/12/27 11:29<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
public interface IdGenerator {

    /**
     * 生成一个主键Id（Long）
     * @return 主键Id
     */
    long getPrimaryKeyIdLong();

    /**
     * 生成一个主键Id（String）
     * @return
     */
    String getPrimaryKeyIdString();
}