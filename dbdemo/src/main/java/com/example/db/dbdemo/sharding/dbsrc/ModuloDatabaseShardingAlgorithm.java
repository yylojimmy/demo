package com.example.db.dbdemo.sharding.dbsrc;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 分库策略的简单实现
 */
public class ModuloDatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<String> {

    @Override
    public String doEqualSharding(Collection<String> databaseNames, ShardingValue<String> shardingValue) {
        for (String each : databaseNames) {
            if (each.endsWith(Long.parseLong(shardingValue.getValue().substring(0,shardingValue.getValue().length()-2)) % 2 + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> databaseNames, ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(databaseNames.size());
        for (String value : shardingValue.getValues()) {
            for (String tableName : databaseNames) {
                if (tableName.endsWith(Long.parseLong(value) % 2 + "")) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> databaseNames, ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(databaseNames.size());
        Range<String> range = (Range<String>) shardingValue.getValueRange();
        for (Long i = Long.parseLong(range.lowerEndpoint()); i <= Long.parseLong(range.upperEndpoint()); i++) {
            for (String each : databaseNames) {
                if (each.endsWith(i % 2 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}