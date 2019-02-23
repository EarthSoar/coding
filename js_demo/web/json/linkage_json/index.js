window.onload = function () {
    var provinceSelect = document.getElementById('provinceSelectId');
    var json = new XMLHttpRequest();
    json.open("GET","/json.action",true);
    json.onreadystatechange = function () {
        if(json.readyState == 4 && json.status == 200){
            var jsonString = json.responseText;//得到JSON字符串
            var jsonArray = eval("("+jsonString+")");//把JSON字符串转化为对象
            //转化为html格式  <option><option/>
            for (var index = 0; index < jsonArray.length; index++){
                var jsonObject = jsonArray[index];
                var optionEle = document.createElement('option');
                optionEle.value = jsonObject.id;
                optionEle.innerHTML = jsonObject.name;
                provinceSelect.appendChild(optionEle);
            }
        }
    };
    json.send();
    
    provinceSelect.onchange = function () {
        var pid = this.value;
        var citySelect = document.getElementById('citySelectId');
        citySelect.innerHTML = "<option value='-1'>请选择</option>";

        if(pid < 0){
            return;
        }

        var json = new XMLHttpRequest();
        json.open("GET","/json_getCityByPid?pid="+pid,true);
        json.onreadystatechange = function () {
            if(json.readyState == 4 && json.status == 200){
                var jsonString = json.responseText;//得到JSON字符串
                var jsonArray = eval("("+jsonString+")");//把JSON字符串转化为对象
                //转化为html格式  <option><option/>
                for (var index = 0; index < jsonArray.length; index++){
                    var jsonObject = jsonArray[index];
                    var optionEle = document.createElement('option');
                    optionEle.value = jsonObject.id;
                    optionEle.innerHTML = jsonObject.name;
                    citySelect.appendChild(optionEle);
                }
            }
        };
        json.send();
    };
};