package com.xt.sys.cache;

import com.xt.sys.domain.Dept;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.rmi.PortableRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: WarehouseSystem
 * @Package: com.xt.sys.cache
 * @ClassName: CacheAspect
 * @Author: xiaoteng
 * @Description: d
 * @Date: 2020/6/2 20:50
 * @Version: 1.0
 */
@Aspect
@Component
@EnableAspectJAutoProxy
public class CacheAspect {

    //声明一个缓存容器
    private Map<String ,Object> CACHE_CONTAINER=new HashMap<>();


    //声明切面表达式
    private static final String POINTCUT_DEPT_UPDATE=
            "execution(* com.xt.sys.service.impl.DeptServiceImpl.updateById(..))";
    private static final String POINTCUT_DEPT_GET=
            "execution(* com.xt.sys.service.impl.DeptServiceImpl.getOne(..))";
    private static final String POINTCUT_DEPT_DELETE=
            "execution(* com.xt.sys.service.impl.DeptServiceImpl.removeById(..))";
    private static final String CACHE_DEPT_PROFIX="dept:";

    //查询切入
    @Around(value = CacheAspect.POINTCUT_DEPT_GET)
    public Object cacheDeptGet(ProceedingJoinPoint joinPoint) throws Throwable {
        //取出第一个参数
        Integer object = (Integer) joinPoint.getArgs()[0];
        //从缓存里面取
        Object res1 = CACHE_CONTAINER.get(CACHE_DEPT_PROFIX + object);

        if (res1!=null){
            return res1;
        }else {
            Dept res2 = (Dept) joinPoint.proceed();
            CACHE_CONTAINER.put(CACHE_DEPT_PROFIX+res2.getId(),res2);
            return res2;
        }
    }}
