window.onload = function () {
    document.getElementById('btn_login').onclick = function () {
        //获取账号和密码
        var usernameText = document.getElementById('username').value;
        var passwordText = document.getElementById('password').value;

        //创建ajax对象
        var ajax = new XMLHttpRequest();
        //创建HTTP请求
        ajax.open("POST","/login",true);

        //===设置POST请求头======
        ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        //=====================
        //设置监听
        ajax.onreadystatechange = function () {
            console.debug("111");
            if(ajax.readyState == 4 && ajax.status == 400){
                //页面跳转
            }
        };
        //请求
        ajax.send("username=" + usernameText + "&password="+passwordText);
    };
};