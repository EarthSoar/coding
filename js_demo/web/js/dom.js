//在加载完文档之后执行
window.onload = function(){
    //========获取元素对象的三种方式===========

    //根据id获取对象
    var divEl = document.getElementById('t');//返回对指定id的第一个对象的引用
    console.debug(divEl);
    console.debug(divEl.innerHTML);//获取元素之间的文本内容,包括html标签
    console.debug(divEl.innerText);//获取元素之间的文本内容,不包括html标签

    //根据名称获取对象
    var eles = document.getElementsByName('hobbys');//返回指定名称name的对象集合NodeList
    console.debug(eles);//NodeList
    console.debug(eles[1]);//获取第二个

    //根据标签名称获取与元素对象
    var inputs = document.getElementsByTagName('input');//返回带有指定标签名称的对象的集合
    console.debug(inputs);

    //=========Node对象的属性和方法============
    /**
     * Node 对象： 把Document,Element,Attr,Text节点都是Node对象
     */
    var divEle = document.getElementById('persons');
    console.debug(divEle);
    // firstChild  获取第一个孩子节点
    console.debug(divEle.firstChild);
    // lastChild
    console.debug(divEle.lastChild);
    // childNodes
    // previousSibling  上一个兄弟
    // nextSibling
    // hasChildNodes()  是否有子节点
    console.debug(divEle.hasChildNodes());

    // nodeName,    节点的名称，根据节点的类型定义
    // nodeValue,   节点的值，根据节点类型定义
    // nodeType,    节点的类型常量

    //元素
    console.debug(document.getElementById('t').nodeName);//标签名称 DIV
    console.debug(document.getElementById('t').nodeType);//常量值  1
    console.debug(document.getElementById('t').nodeValue);//null
    //属性
    var eleNode = document.getElementById('persons');
    var attrNode = eleNode.getAttributeNode('id');
    console.debug(attrNode.nodeName);//属性名称 id
    console.debug(attrNode.nodeType);// 常量值  2
    console.debug(attrNode.nodeValue);//属性值 persons
    //文本
    var text = eleNode.firstChild;
    console.debug(text.nodeName);//#text
    console.debug(text.nodeType);//常量值 3
    console.debug(text.nodeValue);//文本内容

    //======属性的操作(获取/设置)=========
    var inputEle = document.getElementById('xx');
    //标签固有的属性 获取 两种形式获取
    console.debug(inputEle.name);
    console.debug(inputEle['name']);
    console.debug(inputEle.value);
    console.debug(inputEle['value']);
    //自定义的属性 获取方式
    console.debug(inputEle.getAttribute('haha'));

    //属性的设置
    inputEle.name = '腾飞';
    console.debug(inputEle.name);
    inputEle.setAttribute('haha',"我想笑");
    console.debug(inputEle.getAttribute('haha'));

    //操作属性名和默认属性名称相同的的属性 checked,selected
    var checkEle = document.getElementById('checkId');
    console.debug(checkEle.checked);
    checkEle.checked = false;
    //操作class属性,属性名为className
    var cssEle = document.getElementById('p1');
    console.debug(cssEle.className);
    //操作style属性,  如html中标签的属性名font-size的dom属性名称为fontSize
    console.debug(cssEle.style.fontSize);
    //操作readonly属性 属性名为readOnly
    var readEle = document.getElementById('read');
    console.debug(readEle.readOnly);//true
    readEle.readOnly = false;//设置属性
};


//==========Node的常用方法=======

//=======追加节点========appendChild(需要添加的节点);

/**
 * 追加一个节点到另一个节点,作为子元素
 * @param childEleId
 * @param parentEleId
 */
function append2Parent(childEleId,parentEleId) {
    var spanEle = document.getElementById(childEleId);
    var divEle = document.getElementById(parentEleId);
    divEle.appendChild(spanEle);
}

//追加一个新节点
/**
 * @param parentEleId 父节点
 */
function appendNewEle(parentEleId) {
    var spanEle = document.createElement("span");
    spanEle.innerHTML = '新SPN';
    spanEle.style.backgroundColor = 'red';
    var parentEle = document.getElementById(parentEleId);
    parentEle.appendChild(spanEle);
}

//=====在指定节点之前或者之后插入节点=====insertBefore(需要插入的节点,原来的节点);
//把item4插入到item5之前
function insertItem4BeforeItem5() {
    if(!document.getElementById('item4')){
        //新建Item4
        var item4 = document.createElement('option');
        item4.id = 'item4';
        item4.innerHTML = 'Item4';
        //获取Item5
        var item5 = document.getElementById('item5');
        //把Item4插入到Item5之前
        item5.parentNode.insertBefore(item4,item5);
    }
}
//把item4插入到item3之后
function insertItem4AfterItem3() {
    if(!document.getElementById('item4')){
        //新建Item4
        var item4 = document.createElement('option');
        item4.id = 'item4';
        item4.innerHTML = 'Item4';
        //获取Item5
        var item5 = document.getElementById('item5');
        //把Item4插入到Item3之后
        insertAfter(item4,item3);
    }
}
function insertAfter(newNode,refNode) {
    if(refNode.nextSibling){//存在下一个兄弟节点,插入到下一个兄弟节点前面
        refNode.parentNode.insertBefore(newNode,refNode.nextSibling);
    }else{//不存在下一个兄弟节点,追加到父元素后面即可
        refNode.parentNode.appendChild(newNode);
    }
}
//=====删除节点/替换节点======removeChild(父节点的子节点);   replaceChild(替换后节点,原来的节点);
//删除节点
function deleteItem5() {
    var item5 = document.getElementById('item5');
    if(item5){
        item5.parentNode.removeChild(item5);
    }
}
//替换节点
function replaceItem5Item4() {
    //把item5替换为item4
    var item5 = document.getElementById('item5');
    if(item5){
        //新建item4
        var item4 = document.createElement('option');
        item4.id = 'item4';
        item4.innerHTML = 'Item4';

        item5.parentNode.replaceChild(item4,item5);
    }
}
