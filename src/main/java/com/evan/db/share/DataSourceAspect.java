package com.evan.db.share;

import org.aspectj.lang.ProceedingJoinPoint;

import com.evan.db.share.domain.BaseDomain;

public class DataSourceAspect {

    public Object beforeAccessDB(ProceedingJoinPoint pj) throws Throwable {
        Object[] args = pj.getArgs();
        if(args == null || args.length <= 0){
            throw new IllegalArgumentException("访问数据库必须要有参数");
        }
        BaseDomain baseDomain = null;
        for(Object o : args){
            if(o instanceof BaseDomain){
                baseDomain = (BaseDomain) o;
            }
        }
        if(baseDomain == null){
            throw new IllegalArgumentException("访问数据库必须要有BaseDomain类或期子类的参数");
        }
        if(!ShareDBContainer.rightfulProductCode(baseDomain.getProductCode())){
            throw new IllegalArgumentException("访问数据库必须要包含有效的productCode在BaseDomain类或期子类的中,而productCode=\""+baseDomain.getProductCode()+"\"非法");
        }
        ShareDBContainer.setDataSource(baseDomain.getProductCode());
        return pj.proceed();
    }
}
