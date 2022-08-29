package com.hhx.web_code.shardingjdbc.conf;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

@Slf4j
public class PreciseDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        Long shardingNum = ShardingUtil.getShardingNum(preciseShardingValue.getValue());
        String tableName = "userid_tag_" + shardingNum;
        return tableName;
    }

}
