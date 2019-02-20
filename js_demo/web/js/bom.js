
//在加载完文档之后执行
window.onload=function(){
	console.debug(window.document.links);//文档中所有超链接的集合
	console.debug(window.document.links[0]);//获取文档中第一个超链接
	console.debug(window.document.links[0].innerHTML);//获取第一个超链接对应的文本内容
	
	window.document.title = 'test';	//改变页面的标题
	//document.write('您吃了吗');
	
	
	clock();
}
//====消息框/确认框/输入框=======
//1.alert() 显示带有一段消息和一个确认按钮的警告框。 
//alert('这是一个消息框');
//2.confirm() 显示带有一段消息以及确认按钮和取消按钮的对话框。有返回值 
//var r = confirm('好看吗?');
//if(r == true){
//	console.debug('真好');
//}else{
//	console.debug('认真点');
//}
//3.prompt() 显示可提示用户输入的对话框。 
//var name = prompt('你是谁');
//if(name != null && name != ""){
//	console.debug('hello' + name);
//}

//=====打开窗口 关闭窗口
//window.open("http://baidu.com");

//=====移动窗口======
window.moveBy(30,20);//IE支持
window.moveTo(30,20);

//======获取浏览器在屏幕上的坐标
console.debug(window.screenX,window.screenY);
console.debug(window.screenLeft,screenTop);


//====浏览器历史记录
console.debug(history.length);
history.back();//上一条记录
history.forward();//下一条记录
history.go(-2);//上两条记录

//===浏览器信息======
	console.debug(navigator.appVersion);

//location
//location.reload();
console.debug(location.href);
//location.href='http://baidu.com';修改地址栏


//====定时器=======
//setTimeout(code,millisec) 方法用于在指定的毫秒数后调用函数或计算表达式
setTimeout("console.debug('你浪费了人生中宝贵的5秒')",5000);

//setInterval("console.debug('你浪费了人生中宝贵的5秒')",5000);//周期

//---电子时钟----
setInterval('clock()',500);

function clock(){
	var today = new Date();
	var hour = today.getHours();
	var min = today.getMinutes();
	var second = today.getSeconds();
	//分和秒小于10,前面补上0
	min = checkTime(min);
	second = checkTime(second);
	document.getElementById('t').innerHTML = hour + ':' + min + ":" + second;
}

function checkTime(time){
	if(time < 10){
		time = '0' + time;
	}
	return time;
}
