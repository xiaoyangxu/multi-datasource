package com.xxy.aop;

import com.xxy.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by xxy on 2019/7/11.
 * 设置路由key
 * 默认情况下，所有的查询都走从库，插入/修改/删除走主库。我们通过方法名来区分操作类型（CRUD）
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.xxy.annotation.Master) " +
            "&& (execution(* com.xxy.service..*.select*(..)) " +
            "|| execution(* com.xxy.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.xxy.annotation.Master) " +
            "|| execution(* com.xxy.service..*.insert*(..)) " +
            "|| execution(* com.xxy.service..*.add*(..)) " +
            "|| execution(* com.xxy.service..*.update*(..)) " +
            "|| execution(* com.xxy.service..*.edit*(..)) " +
            "|| execution(* com.xxy.service..*.delete*(..)) " +
            "|| execution(* com.xxy.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


/**
 * 另一种写法：if...else... 判断哪些需要读从数据库，其余的走主数据库
 */
// @Before("execution(* com.cjs.example.service.impl.*.*(..))")
// public void before(JoinPoint jp) {
// String methodName = jp.getSignature().getName();
//
// if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
// DBContextHolder.slave();
// }else {
// DBContextHolder.master();
// }
// }
}