package com.example.db.dbdemo.sharding.dbsrc;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 分表策略的基本实现
 * Created by Kane on 2018/1/22.
 */
public class ModuloTableShardingAlgorithm  implements SingleKeyTableShardingAlgorithm<String> {
    @Override
    public String doEqualSharding(Collection<String> tableNames, ShardingValue<String> shardingValue) {
        for (String each : tableNames) {
            if (each.endsWith(Long.parseLong(shardingValue.getValue() )% 2 + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> tableNames, ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableNames.size());
        for (String value : shardingValue.getValues()) {
            for (String tableName : tableNames) {
                if (tableName.endsWith(Long.parseLong(value )% 2 + "")) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> tableNames, ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableNames.size());
        Range<String> range = (Range<String>) shardingValue.getValueRange();
        for (Long i = Long.parseLong(range.lowerEndpoint()); i <= Long.parseLong(range.upperEndpoint()); i++) {
            for (String each : tableNames) {
                if (each.endsWith(i % 2 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }

}
