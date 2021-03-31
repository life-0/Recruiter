(function ($) {
    $(document).ready(function () {
        let Content = getCookie("content")
        console.log(Content)
        if (Content !== "") {
            let content = $('.Content');
            content.text(Content); //将content的cookie值写入小提示的文本框中
            let tip = $('.tip');
            tip.triggerHandler('click');//主动触发 click按钮
            //以下是判断
            let isFocus = false //判断鼠标是否还在标签上
            let Tips=$('.Tips') //锁定某个标签
            Tips.mouseover(function () {
                isFocus = true
            })
            Tips.mouseleave(function (){
                isFocus = false
            })
            //不断循环判断鼠标是否还在标签上,只要不在,清空循环体
            let timeout = setInterval(function () {
                if (!isFocus) {
                    tip.triggerHandler('click')
                    clearInterval(timeout)
                }
            }, 3000)
            // })
        }
    })

    $(".tip,.close").click(function () {
        let BoxTips = $('.BoxTips');
        BoxTips.slideToggle(500)
        BoxTips.css("display", "block")
    });

    $('.testCookie').on('click', function () {
        $('.Content').text(getCookie("content"))
        //$.cookie('the_cookie', '', { expires: -1 }); // 删除 cookie

    })


    //获得cookie值
    function getCookie(name) {
        let strCookie = document.cookie;//获取cookie字符串
        let arrCookie = strCookie.split("; ");//分割
        //遍历匹配
        for (let i = 0; i < arrCookie.length; i++) {
            let arr = arrCookie[i].split("=");
            if (arr[0] === name) {
                return arr[1];
            }
        }
        return "";
    }

})(jQuery);