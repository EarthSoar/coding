//面向对象设计
//定义类
function User(){
	
}
//创建对象
var user = new User();
//给对象设置属性
user.name = 'willing';
user.age = '19';
//给对象设置方法
user.say = sayHello;
user.sleep = function(){
	console.debug("睡觉");
};

//定义一个方法
function sayHello(){
	console.debug(this.name,this.age);//this表示调用此方法的对象
}

console.debug(user);
user.say();//调用对象的方法

//===========

function Person(name,age){
	this.age = age;
	this.name = name;
	this.run = function(){
		console.debug(age,name,'在跑步');
	};
}
var person = new Person('willing',22);
console.debug(person);
person.run();


//========内置对象==========
var obj = new Object();
obj.name='OBJ';
obj.age='18';
obj.doWork = function(){};

console.debug(obj);
console.debug(obj.hasOwnProperty('name'));//判断对象中是否有某一个属性
for(arr in obj){//迭代出每一个属性名和方法
	console.debug(arr);
}
//Number
var number = Number(68);
console.debug(number.valueOf());

//Date
var date = new Date();
console.debug(date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate());
//Math
var i = parseInt(Math.random() * 10); //[0,9)的随机数
console.debug(i);

//String 
//随机生成A-Z之间的字母[65,91);
var code = ((Math.random() * 26)) + 65;
var ch = String.fromCharCode(code);
console.debug(ch);

//数组Array
//三种创建对象
var arr1 = new Array();
arr1[0] = '张三';
arr1[1] = '李四';
arr1[2] = '王五';
console.debug(arr1);

var arr2 = new Array('张三','李四','王五');
console.debug(arr2);

var arr3 = new Array(2);
arr3[0] = '张三';
arr3[1] = '李四';
arr3[2] = '王五';
console.debug(arr3);

var arr4 = ['张三','李四','王五'];
console.debug(arr4);
/**
	 数组常用的方法:
	length－获得数组的长度；
	concat－连接数组；
	join－把数组转换成字符串；
	pop－弹出一个元素；
	push－放入一个元素；
	reverse－颠倒数据中的元素顺序；
	shift－移出第一个元素；
	slice－截取数组;
	sort－排序数组;
	unshift－在前面追加元素；
	splice 从数组中添加/删除/替换元素,若是删除操作,则返回被删除的元素。
 */
console.debug('数组长度='+arr1.length);
var arr = arr1.concat(arr2);
console.debug(arr);
console.debug(arr.join("|"));//把数组按照|切分，默认为,
//arrayObject.splice(index,howmany,element1,.....,elementX)
//index规定从何处添加/删除元素。该参数是开始插入和（或）删除的数组元素的下标，必须是数字。
//howmany规定应该删除多少元素。必须是数字，但可以是 "0"。如果未规定此参数，则删除从 index 开始到原数组结尾的所有元素。
//elementX 规定要添加到数组的新元素。从 index 所指的下标处开始插入。
arr1.splice(2,0,'王麻子');
console.debug(arr1);

//对数组迭代出的是索引
for(index in arr1){
	console.debug(arr1[index]);
}

//给数组定义一个方法,返回当前数组的长度

//arr1.size = function(){
//	return this.length;
//};
//arr1.size();

Array.prototype.size = function(){
	return this.length;
};
console.debug(arr.size());
console.debug(arr1.size());
