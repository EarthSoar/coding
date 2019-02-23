package json;

/**
 * @author Willing
 * @date 2019/2/23
 */

//定义一个IJsonObject接口,定义toJson方法,所有需要把部分属性转换成JSON的类需要来实现该接口.
public interface IJsonObject {
    Object toJson();
}
