package util;

import java.lang.reflect.Method;

/**
 * @author Willing
 * @date 2019/2/16
 */
public class PermissionUtil {
    public static String buildeExpression(Method method) {
        //获取当前method所在类的权限定名称
        return method.getDeclaringClass().getName() + ":" + method.getName();
    }
}
