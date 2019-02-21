
window.onload = function () {
    var submitEl = document.getElementById('btn_submit');
    submitEl.onclick = add;
    var removeEl = document.getElementById('btn_removeAll');
    removeEl.onclick = removeAll;
}

//删除所有
function removeAll() {
    document.getElementById('userTbody').innerHTML = '';
}

//添加用户
function add() {
    //获取文本框的内容
    var usernameText = document.getElementById('username').value;
    var emailText = document.getElementById('email').value;
    var telText = document.getElementById('tel').value;

    //创建tr,td元素
    var trEl = document.createElement('tr');
    var usernameTd = document.createElement('td');
    var emailTd = document.createElement('td');
    var telTd = document.createElement('td');
    var deleteTd = document.createElement('td');

    //给tr设置id属性
    var id = new Date().getTime();
    trEl.id = id;

    //给tr,td设置内容
    usernameTd.innerHTML = usernameText;
    emailTd.innerHTML = emailText;
    telTd.innerHTML = telText;
    deleteTd.innerHTML = "<a href='javascript:deleteUser("+id+")'>删除</a>";

    //建立上下级关系
    trEl.appendChild(usernameTd);
    trEl.appendChild(emailTd);
    trEl.appendChild(telTd);
    trEl.appendChild(deleteTd);
    document.getElementById('userTbody').appendChild(trEl);
}

//删除单个用户
function deleteUser(id) {
    var current = document.getElementById(id);
    current.parentNode.removeChild(current);
}