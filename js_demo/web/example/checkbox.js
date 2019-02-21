
//全选 / 全不选
function checkAll(checked){
    var hobbys =document.getElementsByName('hobby');
    for(var index in hobbys){
        hobbys[index].checked = checked;
    }
}
//反选
function checkUnAll(){
    var hobbys =document.getElementsByName('hobby');
    for(var index in hobbys){
        hobbys[index].checked = !hobbys[index].checked;
    }
}

window.onload = function () {
    var checkEle = document.getElementById('checkAll');
    checkEle.onclick = function () { //给标签添加一个点击事件
        checkAll(this.checked);//this表示当前input标签对象
    }
};