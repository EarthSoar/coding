/**
 * 方式一，相同类型事件只能绑定一个响应函数，JS和Html代码混合，获取不到事件对象
 */
function changeDiv1(current) {
    //alert(current);//事件源
    var divEle = document.getElementById('div1');
    divEle.innerHTML = '方式一：在标签上使用onclick属性配置';
    divEle.style.backgroundColor = 'red';
}

//文档加载完毕后执行
window.onload = function () {
    //得到事件源
    var btn = document.getElementById('btn2');
    //绑定事件
    btn.onclick = function (e) {
        //alert(e);//e为事件对象
        var divEle = document.getElementById('div2');
        divEle.innerHTML = '方式二：在JS代码中使用元素.onclick = 响应函数 的方式来进行事件监听';
        divEle.style.backgroundColor = 'red';
    };


    //===================
    var btn = document.getElementById('btn3');
    //添加事件监听
    addListener(btn,'click',function () {
        var divEle = document.getElementById('div3');
        divEle.innerHTML = '方式三：通过调用方法的方式来进行事件监听';
        divEle.style.backgroundColor = 'red';
    });
};
/**
 *  兼容所有浏览器,添加事件监听
 * @param element   事件源
 * @param eventType 事件类型 如 click点击事件
 * @param callback  处理事件的方法
 */
function addListener(element,eventType,callback) {
    if(element.attachEvent){
        //IE
        element.attachEvent('on' + eventType,callback);
    }else{
        //W3C
        element.addEventListener(eventType,callback);
    }
}