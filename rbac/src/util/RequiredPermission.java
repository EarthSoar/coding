package util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Willing
 * @date 2019/2/16
 */

/*
    用于Action类中需要权限才能访问的方法
 */
@Target(ElementType.METHOD)//该注解贴在方法上
@Retention(RetentionPolicy.RUNTIME)//存活周期到JVM中
public @interface RequiredPermission {
    String value();//权限名称
}
