(function ($) {
    $(document).ready(function () {
        /*FromFrame 传值框架*/

        /*动态输入框*/
        let field = [];    /*存储列的值*/
        let theadValues = $(".table").children('thead').find('tr').children('th');
        theadValues.each(function (key, value) {
            /*console.log(key + " : " + $(value).html())*/
            let json = {};
            if ($(value).attr('readOnly') === 'true') {
                json.name = $(value).html();
                json.readOnly = "true";
            } else {
                json.name = $(value).html();
                json.readOnly = "false";
            }
            field.push(json);
        })
        field.shift();   //去掉头部键值对参数(全选)
        field.pop();     //去掉尾部参数(操作)

        function dynamicInputBox(data) {    //动态加载
            let inputFrame = $(".input-frame");   //获取输入框类
            inputFrame.css("height", 43 * (data.length + 2) + 'px!important');//动态扩容框架
            for (let js in data) {
                // console.log(js + ": " + data[js].name + " " + data[js].readOnly)
                /*'<p>'+data[js].name+'</p>'*/
                inputFrame.find(".operate").before(
                    '<div class="form-group" style="flex-wrap: nowrap;display:flex;">' +
                    '<label style="width: 10%;line-height: 34px;font-size: 10px;margin-right: 5px">' +
                    data[js].name + ":" +
                    '</label>' +
                    '<input type="text" name="id" class="form-control">' +
                    '</div>'
                )
            }

        }

        $(".stripFrame").on('click', function () {
            $(".input-frame").css("display", 'none');
            $(".overlap").css("display", 'none');
        });
        $(".test").on('click', function () {
            let input_frame = $(".input-frame");
            input_frame.css('display', "block");
            input_frame.css("height", 55 * (field.length + 2) + 'px');
            $(".overlap").css("display", 'block');
            dynamicInputBox(field);
        });
    });
})(jQuery);