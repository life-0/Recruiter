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
                    data[js].name +
                    '</label>' +
                    '<input type="text" class="form-control"' +
                    'name="'+data[js].name +'"'+
                    'value="' + data[js].value + '"';
                if (data[js].readonly) {
                    html += 'readonly="' + data[js].readOnly + '">';
                }
                subject.find(".operate").before(
                    html + '</div>'
                )
            }
        }

        function ValAddition(data) {    //动态框中添加值
            let arrayInput = $(".form-content").find('input');
            $.each(arrayInput, function (i, item) {
                $(item).val(data[i].value);
            })
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
            // console.log(updateObjectArray)
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
                else {
                    json.value = "";  //防止value无参数
                }
                // console.log(json.value)
                field.push(json);   //装入数据
            })
            field.shift();   //去掉头部键值对参数(全选)
            field.pop();     //去掉尾部参数(操作)

            //装填数据后再进行修输入框样式
            input_frame.css('display', "");    //修改其可展示状态
            input_frame.css("height", 55 * (field.length + 2) + 'px');  //修改动态扩容其高度
            $(".overlap").css("display", 'block');
            // 检查已经存在动态输入框了

            if ($(".form-content:has(.form-group)").length > 0){
                ValAddition(field); //添加值
            }
            else
            {
                dynamicInputBox(field, input_frame);    //创建输入框,且添加值
            }

            //存储初始值到浏览器中
            for (let fieldElement of field) {
                    // console.log(fieldElement['name']+":"+fieldElement['value'])
                //浏览器中存储初始值, 若会话消失,则初始值被删除
                //sessionStorage 用于临时保存同一窗口(或标签页)的数据，在关闭窗口或标签页之后将会删除这些数据。
                sessionStorage.setItem(fieldElement['name'], fieldElement['value']);
                origin.push(fieldElement.value);
            }

        });
    });
})(jQuery);