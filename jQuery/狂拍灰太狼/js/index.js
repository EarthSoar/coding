$(function () {
    // 1.监听游戏规则的点击
    $(".rules").click(function () {
        $(".rule").stop().fadeIn(100);
    });
    // 2.监听关闭按钮的点击
    $(".close").click(function () {
        $(".rule").stop().fadeOut(100);
    });
    // 3.监听开始游戏按钮的点击
    $(".start").click(function () {
        //开始按钮渐出
        $(this).stop().fadeOut(100);
        //调用方法处理进度条
        progressHandler();
        // 处理灰太狼动画
        startWolfAnimation();
    });
    // 4.监听重新开始游戏的点击
    $(".reStart").click(function () {
        // 重新开始界面渐出
        $(".mask").stop().fadeOut(100);
        $(".score").text(0);
        // 处理进度条
        progressHandler();
        // 开启动画
        startWolfAnimation();
    });


    //处理进度条
    function progressHandler() {
        // 初始化进度条的宽度
        $(".progress").css({
            width: 180
        });
        // 开启定时器处理进度条
       var timer = setInterval(function () {
            //先获取到当前进度条的宽度
            var curProgressWidth = $(".progress").width();
            // 减少当前长度
            curProgressWidth -= 1;
            // 更新进度条实际宽度
            $(".progress").css({
                width:curProgressWidth
            });
            // 判断进度条是否走完
            if(curProgressWidth <= 0){
                // 关闭定时器
                clearInterval(timer);
                // 显示重新开始界面
                $(".mask").stop().fadeIn(100);
                // 停止灰太狼的动画
                stopWolfAnimation();
            }
        },100);
    }

    var wolfTimer;
    //处理灰太狼的动画效果
    function startWolfAnimation(){
        // 1.用两个数组存放灰太狼和小灰灰的所有图片
        var wolf_1=['./images/h0.png','./images/h1.png','./images/h2.png','./images/h3.png','./images/h4.png','./images/h5.png','./images/h6.png','./images/h7.png','./images/h8.png','./images/h9.png'];
        var wolf_2=['./images/x0.png','./images/x1.png','./images/x2.png','./images/x3.png','./images/x4.png','./images/x5.png','./images/x6.png','./images/x7.png','./images/x8.png','./images/x9.png'];
        // 2.用一个数组存储所有可能出现的位置(坑的位置)
        var arrPos = [
            {left:"100px",top:"115px"},
            {left:"20px",top:"160px"},
            {left:"190px",top:"142px"},
            {left:"105px",top:"193px"},
            {left:"19px",top:"221px"},
            {left:"202px",top:"212px"},
            {left:"120px",top:"275px"},
            {left:"30px",top:"295px"},
            {left:"209px",top:"297px"}
        ];

        // 3.创建一张图片
        var $wolfImage = $("<image src='' class='wolfImage'/>");
        // 4.设置图片的位置(用随机索引从数组中取出来)
        var posIndex = Math.round(Math.random() * 8);
        $wolfImage.css({
            position: "absolute",
            left: arrPos[posIndex].left,
            top: arrPos[posIndex].top
        });
        // 5.设置图片的内容
        window.wolfIndex = 0;//从第wolfIndex个索引开始取图片
        window.wolfIndexEnd = 5;//到第5个索引结束
        var wolfType = Math.round(Math.random()) == 0 ? wolf_1 : wolf_2;
        wolfTimer = setInterval(function () {
            //如果索引超过了wolfIndexEnd,
            if(wolfIndex > wolfIndexEnd){
                // 删除当前图片
                $wolfImage.remove();
                // 关闭定时器
                clearInterval(wolfTimer);
                // 又重新开始处理
                startWolfAnimation();
            }
            $wolfImage.attr("src",wolfType[wolfIndex]);
            wolfIndex++;
        },200);
        // 6.将图片添加到界面上
        $(".container").append($wolfImage);
        // 7.处理游戏规则
        gameRules($wolfImage);
    }

    //处理游戏规则
    function gameRules($wolfImage) {
        // 对图片监听点击事件
        $wolfImage.one("click",function () {
            // 修改去图片的索引,出现被打击的效果
            window.wolfIndex = 5;
            window.wolfIndexEnd = 9;

            // 根据图片的地址名称 判断点击的是灰太狼还是小灰灰
            var $src = $(this).attr("src");
            var flag = $src.indexOf("h") >= 0; //true:灰太狼;false:小灰灰
            if(flag){
                // 分数+10
                $(".score").text(parseInt($(".score").text()) + 10);
            }else {
                $(".score").text(parseInt($(".score").text()) - 10);
            }
        })
    }

    //停止灰太狼的动画
    function stopWolfAnimation() {
        //删除图片
        $(".wolfImage").remove();
        //关闭定时器
        clearInterval(wolfTimer);
    }
})