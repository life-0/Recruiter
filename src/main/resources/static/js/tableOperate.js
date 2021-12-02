(function ($) {
    /*表的自定义方法,事件*/
    $(".BatchProcess").click(function () {  //批删除
        let arr = $("input:checkbox:checked").map(function () {
            return $(this).val();
        }).get().join(",");
        console.log(arr);
        data(arr);
    });

    $('.SingleDel').click(function () { //单个删除
        data($(this).attr('value'));
    });

    $(".SingleModify").on('click', function () {    //单个编辑 传参
        // $.post("/student/ToUpdate", {ID: $(this).attr('value')})
        window.location.href = "/student/ToUpdate/" + $(this).attr('value');
    });

})(jQuery);