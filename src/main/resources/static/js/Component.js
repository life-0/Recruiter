(function ($) {
    let BoxTips = $('.BoxTips');
    $(".tip,.close").on('click', function () {
        BoxTips.slideToggle(500)
        BoxTips.css("display", "block")
    });
    // BoxTips.on('click', function () {
    //     window.alert(getCookie("content"))
    // });
    $('.testCookie').on('click', function () {
      $('.Content').text(getCookie("content"))
        
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