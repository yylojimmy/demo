package com.example.db.dbdemo.dbsrc;

import com.example.db.dbdemo.dto.OrderTable;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {
    DatabaseType[] dbTypeList = new DatabaseType[]{DatabaseType.D3306, DatabaseType.D3307};

    @Before("execution(* com.example.db.dbdemo.mapper.*.*(..))")
    public void setDataSourceKey(JoinPoint point){
        System.out.println("---aop ---"+point.getTarget().getClass().getName()+" ---- "+point.getSignature().getName());
        Object[] params = point.getArgs();
        OrderTable orderTable = (OrderTable)params[0];
        int count = DatabaseType.values().length;
        System.out.println("---db count ---"+count+" ---- order customer no = "+orderTable.getCustomerNo());
        int index = Integer.parseInt(orderTable.getCustomerNo()) % count;

        DatabaseContextHolder.setDatabaseType(dbTypeList[index]);
        //连接点所属的类实例是ShopDao
        /*if(point.getTarget() instanceof OrderMapper){
            DatabaseContextHolder.setDatabaseType(DatabaseType.D3306);
        }else{//连接点所属的类实例是UserDao（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的mytestdb）
            DatabaseContextHolder.setDatabaseType(DatabaseType.D3307);
        }*/
    }
}
