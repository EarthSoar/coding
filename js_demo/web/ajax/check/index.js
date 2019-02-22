window.onload = function () {
    document.getElementById('username').onblur = function () {
        var usernameText = this.value;//得到文本框的值

        //创建ajax对象
        var ajax = createAjax();
        //创建HTTP请求
        ajax.open("GET","/check?username=" + usernameText,true);
        //监听状态
        ajax.onreadystatechange = function () {
            if(ajax.readyState == 4 && ajax.status == 200){
                document.getElementById("msg").innerHTML = ajax.responseText;
            }
        }
        //发送请求
        ajax.send();
    };
};


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