(function ($) {
    let BoxTips = $('.BoxTips');
    $(".tip,.close").on('click', function () {
        BoxTips.slideToggle(500)
        BoxTips.css("display", "block")
    });
    BoxTips.on('blur',function (){
        for (const cookieElement of document.cookie) {
            console.log(cookieElement.valueOf());
        }
    })
})(jQuery);