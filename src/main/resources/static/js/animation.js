(function ($) {
    "use strict";
    var config = {
        enter: 'bottom',
        move: '40px',
        over: '0.16s',
        reset: true,
        init: false
    };
    window.scrollReveal = new scrollReveal(config);
    var data = {newElementHtml: '<div data-scroll-reveal>dowebok.com</div>'};
    var container = document.getElementById('#container');
    container.innerHTML(data.newElementHTML);
    scrollReveal.init();
}(jQuery));