package com.hhx.web_code.shardingjdbc.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Maps;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * @author hhx
 * @date 2022/8/12
 * @note https://blog.csdn.net/qq_20128967/article/details/111524231
 * https://github.com/JazzHeric/ShardingSphereComplexDatabaseShardingAlgorithm/blob/master/test_heric_sharding/src/main/resources/application.yml
 * https://github.com/xiao-ren-wu/sharding-all/blob/master/sub-db-table/src/main/java/org/ywb/subdbtable/sharding/UserPreciseShardingAlgorithm.java
 */
@Configuration
public class DataSourceConfig {
    @Bean("dataSource00")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl);
        setConnectionProperty(druidDataSource);
        return druidDataSource;
    }


    private void setConnectionProperty(DruidDataSource druidDataSource) {
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
    }


    private Map<String, DataSource> buildDataSourceMap() {
        Map<String, DataSource> result = Maps.newHashMap();
        result.put("db_source_00", druidDataSource());

        return result;
    }

    @Bean("shardingDataSource")
    DataSource getShardingDataSource() throws SQLException {

        //设置表精准sharding规则
        TableRuleConfiguration orderDetailTableRule = new TableRuleConfiguration("userid_tag", "db_source_00.userid_tag_${0..9}");
        // 配置分表策略
        StandardShardingStrategyConfiguration standardShardingStrategyConfiguration =
                new StandardShardingStrategyConfiguration("user_id",
                        new PreciseDatabaseShardingAlgorithm());
        orderDetailTableRule.setTableShardingStrategyConfig(standardShardingStrategyConfiguration);


        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderDetailTableRule);

        shardingRuleConfig.getBindingTableGroups().
                add("userid_tag_0," +
                        "userid_tag_1," +
                        "userid_tag_2," +
                        "userid_tag_3" +
                        "userid_tag_4" +
                        "userid_tag_5" +
                        "userid_tag_6" +
                        "userid_tag_7" +
                        "userid_tag_8" +
                        "userid_tag_9");
        //设置默认规则
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(standardShardingStrategyConfiguration);

        return ShardingDataSourceFactory.createDataSource(buildDataSourceMap(), shardingRuleConfig, new Properties());
    }

    @Bean
    public PlatformTransactionManager shardingTransactionManager() throws Exception {
        return new DataSourceTransactionManager(getShardingDataSource());
    }


    /**
     * ---------------------数据库连接配置----------------------
     */
    @Value("${spring.datasource.url}")
    private String dbUrl;


    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.maxEvictableIdleTimeMillis}")
    private Long maxEvictableIdleTimeMillis;
}
