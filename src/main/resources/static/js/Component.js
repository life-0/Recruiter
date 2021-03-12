(function ($) {
    let BoxTips = $('.BoxTips');
    $(".tip,.close").on('click', function () {
        BoxTips.slideToggle(500)
        BoxTips.css("display", "block")
    });
})(jQuery);