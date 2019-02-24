$(function () {
    //得到的是DOM对象
    var divEle = document.getElementById('div1');
    console.log(divEle);
    console.log(divEle.innerHTML);
    //得到的是jQuery对象
    var divObject = $("#div2");
    console.log(divObject);
    console.log(divObject.text());
    //--DOM对象和jQuery对象的相互转化

    //DOM -> jQuery 对象  $(DOM对象)
    console.log($(divEle));
    //jQuery对象 -> DOM对象   jQuery对象[index]  相当于一个数组
    console.log(divObject[0]);
    console.log(divObject.get(0));
})



