/**
 * 全部移动
 * @param srcSelectId   源
 * @param destSelectId  目的
 */
function sel1AddAllTosel2(srcSelectId,destSelectId) {
    var select1 = document.getElementById(srcSelectId);
    var select2 = document.getElementById(destSelectId);

    while(select1.hasChildNodes()){
        select2.appendChild(select1.firstChild);//每次把select的第一个子元素追加到select2的子元素后面
    }
}

/**
 * 选择移动
 * @param srcSelectId   源
 * @param destSelectId  目的
 */
function sel1AddTosel2(srcSelectId,destSelectId) {
    var select1 = document.getElementById(srcSelectId);
    var select2 = document.getElementById(destSelectId);

    var options = select1.getElementsByTagName('option');
    for(var index = 0; index < options.length; index++){
        var optionEle = options[index];
        if(optionEle.selected){
            select2.appendChild(optionEle);
            index--;
        }
    }
}