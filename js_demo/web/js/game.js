//文档加载完毕后执行
window.onload = function () {
    var startBtn = document.getElementById('startBtn');
    startBtn.disabled = false;
    startBtn.onclick = start;//设置点击事件
};

//存储新建的label
var labelArray = new Array();

//开始游戏
function start() {
    //1.禁用开始游戏按钮
    this.disabled = true;
    //2.定时随机生成字符显示到页面上
    setInterval(function () {
        //2.1创建 <label/>元素,并添加到数组中
        var label = createLabel();
        labelArray.push(label);
        //2.2把元素添加到body中去
        document.body.appendChild(label);
    },1000);

    //3.让页面中的字符向下移动
    setInterval(function () {
        for(var i = 0; i < labelArray.length; i++){
            var label = labelArray[i];
            var oldTop = parseInt(label.style.top);
            //屏幕的高度
            var screenHeight = document.documentElement.clientHeight - 30;
            if(oldTop < screenHeight){
                label.style.top = oldTop + 10 + 'px';
            }
            if(oldTop > screenHeight - 30){
                labelArray.splice(i,1);
                document.body.removeChild(label);
            }
        }
    },1000);

    //4.捕捉玩家点击事件
    document.onkeydown = function(event) {
        var keyCode = event.keyCode;
        var charCode = String.fromCharCode(keyCode);
        for(var i = 0; i < labelArray.length; i++){
            var label = labelArray[i];
            if(label.innerHTML == charCode){
                //从body中删除label元素,并且清空数组中的字符
                labelArray.splice(i,1);
                document.body.removeChild(label);
                break;
            }
        }
    };
}

// <label style="position:absolute;top:30px;left:10px;background-color:red;width:20px;text-align:center;
//font-weight:bold;"></label>
function createLabel(){
    //1.得打[65,91)之间的随机整数
    var randomNum = parseInt((Math.random() * 26) + 65);
    //2.得到A-Z的随机字母
    var charCode = String.fromCharCode(randomNum);

    //3.创建<label>元素,并设置元素的属性
    var labelEle = document.createElement('label');
    labelEle.style.width = '25px';
    labelEle.style.backgroundColor = 'orange';
    labelEle.style.textAlign = 'center';
    labelEle.style.fontWeight='bold';
    //3.1 获取屏幕宽度
    var screenWidth = document.documentElement.clientWidth - 30;
    labelEle.style.left = Math.random() * screenWidth + "px";
    labelEle.style.top=30+'px';
    labelEle.style.position = 'absolute';//生成绝对定位的元素
    labelEle.innerHTML = charCode;
    return labelEle;
}