
//----1.变量定义和打印----
var username = "willing";
//alert(username);//弹出窗口打印
console.debug("username=",username);//控制台打印

//----2.运算符------
//1.比较运算符
var age = 19;//Number
var str = "19";//String
console.debug(age==str);//比较值,true
console.debug(age===str);//先比较类型,在比较值,false
//2.逻辑运算符 :    0、""、false、null、undefined、NaN均表示false
if(-1){
	console.debug("成立");
}
//3.与运算 和或运算 
/**
 * &&运算  返回最后一个为true的值,或者第一个为false的值
 * ||运算  返回第一个为true的值,或者最后一个为false的值
 */
console.debug(5&&1&&0&&1);//0
console.debug(""||1||8||0||null||"");//1

//----4.函数调用----
function sayHello(){
	console.debug("函数调用");
}
sayHello();//调用函数
function add(x,y){//带参数的函数
	var ret = x + y;
	return ret;
}
i = add(1,3);//有返回
console.debug(add(1,2));
console.debug(i);
//匿名函数
var sum = function(x,y){
	return x + y;
};
console.debug(sum(3,3));//匿名函数调用



//5.系统函数
console.debug(encodeURI("http://www.baidu.com?name=吃了吗"));//编码
console.debug(decodeURI("http://www.baidu.com?name=%E5%90%83%E4%BA%86%E5%90%97"));//解码

console.debug(parseInt("112AA312.11"));
console.debug(parseFloat("A112312.11"));//NaN