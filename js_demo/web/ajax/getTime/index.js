window.onload = function () {
    document.getElementById('btn_getTime').onclick = getServerTime;
};

function getServerTime() {
    //1.创建Ajax对象,XMLHttpRequest用于在后台与服务器交换数据
    var ajax = createAjax();
    //2.创建HTTP请求,设置请求方式，请求的URL,是否使用异步
    /**
        open(method,url,async)
         规定请求的类型、URL 以及是否异步处理请求。
         method：请求的类型；GET 或 POST
         url：文件在服务器上的位置
         async：true（异步）或 false（同步）
     */
    ajax.open("GET","/time?"+new Date().getTime(),true);
    //4.设置监听事件
    ajax.onreadystatechange = function () {
        /**
             存有 XMLHttpRequest 的状态。从 0 到 4 发生变化。  触发5次事件
             0: 请求未初始化
             1: 服务器连接已建立
             2: 请求已接收
             3: 请求处理中
             4: 请求已完成，且响应已就绪
         */
        if(ajax.readyState == 4 && ajax.status == 200){
            /**
             * 获取服务器的响应
             * responseText	获得字符串形式的响应数据
             * responseXML	获得 XML 形式的响应数据。
             */
            document.getElementById('time').innerHTML = ajax.responseText;
        }
    };
    //3.发送请求
    /**
         send(string)
         将请求发送到服务器。
         string：仅用于 POST 请求
     */
    ajax.send();
}

//浏览器兼容
function createAjax() {
    var ajax;
    try{
        // code for IE7+, Firefox, Chrome, Opera, Safari
        ajax = new XMLHttpRequest();
    }catch (e){
        // code for IE6, IE5
        ajax = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return ajax;
}