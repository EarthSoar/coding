window.onload = function () {
    var provinceSelect = document.getElementById('provinceSelectId');

    var ajax = new XMLHttpRequest();
    ajax.open("GET","/html",true);
    ajax.onreadystatechange = function () {
        if(ajax.readyState == 4 && ajax.status == 200){
            //接收服务端的数据
            provinceSelect.innerHTML += ajax.responseText;
        }
    };
    ajax.send();


    //===城市====
    var citySelect = document.getElementById('citySelectId');
    //当省份发生变化时
    provinceSelect.onchange = function () {
        var pid = this.value;//省份的ID
        //把城市的内容重新置为空
        citySelect.innerHTML = "<option value='-1'>请选择</option>";

        if(pid < 0){
            return;
        }
        var ajax = new XMLHttpRequest();
        ajax.open("GET","/html_getCityById?pid="+pid,true);
        ajax.onreadystatechange = function () {
            if(ajax.readyState == 4 && ajax.status == 200){
                citySelect.innerHTML += ajax.responseText;
            }
        };
        ajax.send();
    };
};