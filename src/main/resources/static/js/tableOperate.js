import {transport} from "./dataTransport.js";

(function ($) {
    /*表的自定义方法,事件*/
    /* import('./dataTransport.js');*/
    // export {transport} from "./dataTransport";  //导入数据传输方法

    $(".BatchProcess").click(function () {  //批删除
        let arr = $("input:checkbox:checked").map(function () {
            return $(this).val();
        }).get().join(",");
        console.log(arr);
        transport(arr, 'post', $(this).prop('targetHref'));
    });

    $('.SingleDel').click(function () {
        //单个删除
        console.log($(this).attr('value'), $(this).attr('targetHref'));
        // _method:"PUT"
        const data = {list: [$(this).attr('value')]}
        transport(data, 'DELETE', $(this).attr('targetHref'));
    });

    $(".SingleModify").on('click', function () {    //单个编辑 传参
        // $.post("/student/ToUpdate", {ID: $(this).attr('value')})
        // window.location.href = "/student/ToUpdate/" + $(this).attr('value');
    });

})(jQuery);