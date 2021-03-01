(function ($) {

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

    function data(arr) {
        $.ajax({
            type: "POST", //提交方式
            dataType: "json",
            url: "/student/DeleteStu",//路径
            data: {
                "data": arr
            },//数据，这里使用的是Json格式进行传输
            success: function (result) {//返回数据根据结果进行相应的处理
                if (result.toString() === 'ok') {
                    window.alert('Yes')
                } else {
                    window.alert("Error");
                }
            }
        });
    }
})(jQuery);

