//用原生的JS
window.onload = function () {
    document.getElementById('btn_change1').onclick = function () {
        document.getElementById('div1').innerHTML = '改变内容';
    };
};

//用jQuery改变
$(function () {
    $("#btn_change2").click(function () {
        $("#div2").html("改变Div2的内容");
    })
})

//模拟struts的debug标签
//用原生的JS
window.onload = function () {
    document.getElementById('debug1').onclick = function () {
        var divEle = document.getElementById('text');
        if(divEle.style.display){
            divEle.style.display = "";
        }else{
            divEle.style.display = "none";
        }
    };
}
//用jQuery
$(function () {
    $("#debug2").click(function () {
        $("#text").toggle(3000);//开关
    });
})