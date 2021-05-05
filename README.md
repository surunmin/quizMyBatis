# quizMyBatis
作为mybatis的扩展框架使用
目前处于 1.0.0版本


#### 如何使用
如何使用</br>
在SpringBoot中使用@Bean注入方式
```java
@Configuration
public class BeanConfig { 
    @Bean
     public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
         QuizSqlSessionFactoryBean quizSqlSessionFactoryBean = new QuizSqlSessionFactoryBean();
         quizSqlSessionFactoryBean.setDataSource(dataSource);
         quizSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                 .getResources("classpath:/mapper/*.xml"));
    
         QuizConfiguration quizConfiguration = new QuizConfiguration();
         quizConfiguration.setMapUnderscoreToCamelCase(true);
         quizSqlSessionFactoryBean.setQuizConfiguration(quizConfiguration);
         return quizSqlSessionFactoryBean.getObject();
     } 
}
```