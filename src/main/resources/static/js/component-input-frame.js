(function ($) {
    $(document).ready(function () {
        /*FromFrame 传值框架*/

        function dynamicInputBox(data, subject) {
            //动态加载,当前数据,当前对象

            for (let js in data) {
                // console.log(js + ": " + data[js].name + " " + data[js].readOnly)
                /*'<p>'+data[js].name+'</p>'*/
                let html = '<div class="form-group" style="flex-wrap: nowrap;display:flex;">' +
                    '<label style="width: 10%;line-height: 34px;font-size: 10px;margin-right: 5px">' +
                    data[js].name + ":" +
                    '</label>' +
                    '<input type="text" name="id" class="form-control" ' +
                    'value="' + data[js].value + '"';
                if (data[js].readonly) {
                    html += 'readonly="' + data[js].readOnly + '">';
                }
                subject.find(".operate").before(
                    html + '</div>'
                )
            }

        }

        $(".stripFrame").on('click', function () {
            $(".input-frame").css("display", 'none');
            $(".overlap").css("display", 'none');
        });
        $(".test").on('click', function () {
            /*动态输入框*/
            let field = [];    /*存储列的值*/
            let theadValues = $(".table").children('thead').find('tr').children('th');/*获取展示表的字段*/
            let input_frame = $(".input-frame");    /*获取输入框类*/
            let updateObjectArray = $(this).parents('td').siblings();    //获取值
            updateObjectArray.push($(this));    //添加自身,补齐个数
            console.log(updateObjectArray)
            theadValues.each(function (key, value) {
                /*console.log(key + " : " + $(value).html())*/
                let json = {};
                json.name = $(value).html();
                console.log()
                if (updateObjectArray[key].className === "updateInvalid") {
                    json.readonly = true;
                }

                if (updateObjectArray[key].innerText)
                    json.value = updateObjectArray[key].innerText;
                // console.log(json.value)
                field.push(json);   //装入数据
            })
            field.shift();   //去掉头部键值对参数(全选)
            field.pop();     //去掉尾部参数(操作)

            //装填数据后再进行修输入框样式
            input_frame.css('display', "block");    //修改其可展示状态
            input_frame.css("height", 55 * (field.length + 2) + 'px');  //修改动态扩容其高度
            $(".overlap").css("display", 'block');
            dynamicInputBox(field, input_frame);
        });
    });
})(jQuery);