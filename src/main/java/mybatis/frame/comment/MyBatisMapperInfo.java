package mybatis.frame.comment;

import lombok.Data;
import org.apache.ibatis.builder.MapperBuilderAssistant;

import java.util.List;

@Data
public class MyBatisMapperInfo {

    /**
     * mapper创建代理类
     */
    private MapperBuilderAssistant assistant;

    /**
     * 方法集合
     */
    private List<MyBatisXMLInfo> myBatisXMLInfos;

}
