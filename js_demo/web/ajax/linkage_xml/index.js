window.onload = function () {
    var provinceSelect = document.getElementById('provinceSelectId');
    var ajax = new XMLHttpRequest();
    ajax.open("GET","/xml",true);
    ajax.onreadystatechange = function () {
        if(ajax.readyState == 4 && ajax.status == 200){

            var doc = ajax.responseXML;//得到xml文档内容
            var datas = doc.getElementsByTagName("data");
            //转化为html格式  <option><option/>
            for (var index = 0; index < datas.length; index++){
                var dataEle = datas[index];
                var optionEle = document.createElement('option');
                optionEle.value = dataEle.id;
                optionEle.innerHTML = dataEle.innerHTML;
                provinceSelect.appendChild(optionEle);
            }
        }
    };
    ajax.send();

    //=========城市option========
    provinceSelect.onchange = function () {
        var pid = this.value;
        if(pid < 0){
            return;
        }
        var citySelect = document.getElementById('citySelectId');
        citySelect.innerHTML = "<option value='-1'>请选择</option>";

        var ajax = new XMLHttpRequest();
        ajax.open("GET","/xml_getCityByPid?pid="+pid,true);
        ajax.onreadystatechange = function () {
            if(ajax.readyState == 4 && ajax.status == 200){

                var doc = ajax.responseXML;//得到xml文档内容
                var datas = doc.getElementsByTagName("data");
                //转化为html格式  <option><option/>
                for (var index = 0; index < datas.length; index++){
                    var dataEle = datas[index];
                    var optionEle = document.createElement('option');
                    optionEle.value = dataEle.id;
                    optionEle.innerHTML = dataEle.innerHTML;
                    citySelect.appendChild(optionEle);
                }
            }
        };
        ajax.send();
    };
};