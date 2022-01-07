import {transport} from "./dataTransport.js";

(function ($) {
    /*表的自定义方法,事件*/
    /* import('./dataTransport.js');*/
    // export {transport} from "./dataTransport";  //导入数据传输方法

    $(".BatchProcess").click(function () {  //批删除
        let arr = $("input:checkbox:checked").map(function () {
            return parseInt($(this).val());
        }).get();   //map,将数组每一个元素遍历一次
        transport(arr, 'DELETE', $(this).attr('targetHref'));
        /*if (arr != null) {  //防止无数据传入
            transport(arr, 'DELETE', $(this).attr('targetHref'));
        } else {
            alert(arr + '无数据');
        }
*/

    });

    $('.SingleDel').click(function () {
        //单个删除
        const data = [parseInt($(this).attr('value'))]  // 以数组的形式传递
        console.log(data, $(this).attr('targetHref'));
        transport(data, 'DELETE', $(this).attr('targetHref'));
    });

})(jQuery);