(function ($) {
    $(document).ready(function () {
        const singleValue = [{category: {name: '男', value: true}}, {category: {name: '女', value: false}}]; // 单选框值
        /*
        * 动态加载 传值框架
        * data 数据
        * subject 当前对象,
        * targetUrl 提交地址
        * */
        function dynamicInputBox(data, subject, targetUrl) {
            for (let js in data) {
                // console.log(js + ": " + data[js].name + " " + data[js].readOnly)
                /// console.log(data[js])
                /*'<p>'+data[js].name+'</p>'*/
                let html = '<div class="form-group" style="flex-wrap: nowrap;display:flex;">'

                if (data[js].type === 'text') { // 文本框
                    html += '<label style="width: 10%;line-height: 34px;font-size: 10px;margin-right: 5px">'
                        + data[js].name + '</label>';
                    html += '<input class="form-control"' +
                        ' name="' + data[js].name + '"' +
                        ' value="' + data[js].value + '"' +
                        ' type="' + data[js].type + '"';
                    if (data[js].readonly) {
                        html += ' readonly="' + data[js].readOnly + '"';
                    }
                    html += '>';
                }
                if (data[js].type === 'radio') {    // 单选框
                    html += '<label style="width: 10%;line-height: 34px;font-size: 10px;margin-right: 5px">'
                        + data[js].name + '</label>';
                    for (let item of singleValue) { // 单选框的值
                        // console.log("name: " + item.category.name, "value: " + item.category.value)
                        html += '<label style="width: 15%; margin: 0 auto;line-height: 34px;font-size: 16px">';
                        html += '<input class="form-check-input" ' +
                            ' type="' + data[js].type + '" ' +
                            ' name="' + data[js].name + '" ' +
                            ' value="' + item.category.value + '"' +
                            ' style="' + 'zoom:160%;' + '" ' +
                            (data[js].value === item.category.name ? "checked" : '') +
                            '>' +
                            '<span>' + item.category.name + '</span>' +
                            '</label>';
                    }
                }
                subject.find(".operate").before(
                    html + '</div>'
                )
            }
        }

        /*
        动态框中添加值
        * data 数据 json格式
        * */
        function valAddition(data) {    //动态框中添加值
            let arrayInput = $(".form-content").find('input');  // 获取动态输入框的 input标签,填充值
            // console.log(arrayInput)
            $.each(data, function (i, item) {
                if (item.type === 'text') {
                    // console.log(arrayInput.filter(element => item.name === $(element).attr('name') ? $(element) : null))
                    let targetInput = arrayInput.filter((index, element, self) => { // 索引值, 当前数组项, 数组自身
                        return $(element).attr("name") === item.name;
                    })
                    if (targetInput !== null) {
                        targetInput.val(item.value)    // text类型直接装入值
                    }
                }
                if (data[i].type === 'radio') {    // radio类型要进行筛选
                    // 获取radio类型,且name相同的inputs
                    let singleInputs = arrayInput.filter(function (index, element, self) {
                        return $(element).prop('type') === 'radio' && data[i].name === $(element).prop('name');
                    });

                    singleInputs.each(function (index, value) {  // 把radio选中的值填充进去
                        // console.log($(value).next().text())
                        // console.log($(value),index)
                        $(value).removeProp('checked')  // 清除所有的checked指定
                        if ($(value).next().text() === item.value) {   //获取span标签数据的指定
                            $(value).prop('checked', true);   // 选中设定
                        }
                    })
                }
            });

        }

        /*
        * 获取数据,以json格式进行装填
        *
        * */

        /*
        打开输入框
        * inputFrame 输入框对象
        * overlap 围布对象
        * rowCount 输出栏行数
        * */
        function openInputFrame(inputFrame, overlap, rowCount) {
            //装填数据后再进行修输入框样式
            inputFrame.css('display', 'block');    //修改其可展示状态
            inputFrame.css("height", 56 * (rowCount.length + 2) + 'px');  //修改动态扩容其高度
            overlap.css("display", 'block');
        }

        $(".stripFrame").on('click', function () {
            $(".input-frame").css("display", 'none');
            $(".overlap").css("display", 'none');
            sessionStorage.clear();// 清空数据
        });
        /*
        *
        * 修改按钮
        * */
        $(".test").on('click', function () {
            /*动态输入框*/
            let field = [];    // 存储列的值
            let theadValues = $(".table").children('thead').find('tr').children('th');  // 获取展示表的字段
            let input_frame = $(".input-frame-Css");    // 获取输入框类
            let updateObjectArray = $(this).parents('td').siblings();    // 获取值
            updateObjectArray.push($(this));    // 添加自身,补齐个数
            // console.log(updateObjectArray)
            theadValues.each(function (index, value) {
                let json = {};
                json.name = $(value).html();
                if (updateObjectArray[index].className === "updateInvalid") {
                    json.readonly = true;
                }
                if (updateObjectArray[index].className === "singleBox") {
                    json.type = "radio";
                } else {
                    json.type = "text";    // 防止type无参数
                }
                if (updateObjectArray[index].innerText)
                    json.value = updateObjectArray[index].innerText;
                else {
                    json.value = "";  //防止value无参数
                }
                // console.log(json.value)
                field.push(json);   // 装入数据
            })
            field.shift();   // 去掉头部键值对参数(全选)
            field.pop();     // 去掉尾部参数(操作)
            openInputFrame(input_frame, $('.overlap'), field)    // 打开动态输入框

            // 检查已经存在动态输入框了

            if ($(".form-content:has(.form-group)").length > 0) {
                valAddition(field);     // 添加值
            } else {
                dynamicInputBox(field, input_frame, field);    // 创建输入框,且添加值
            }
            //存储初始值到浏览器中
            for (let fieldElement of field) {
                // console.log(fieldElement['name']+":"+fieldElement['value'])
                //浏览器中存储初始值, 若会话消失,则初始值被删除
                //sessionStorage 用于临时保存同一窗口(或标签页)的数据，在关闭窗口或标签页之后将会删除这些数据。
                sessionStorage.setItem(fieldElement['name'], fieldElement['value']);
            }
            //  设置数据提交路径
            $('.submitData').attr('targetHref', ($(this).attr('targetHref')))
        });
        /*update end*/

        /*add*/
        $(".addData").on('click', function () {
            let field = [];    /*存储列的值*/
            let input_frame = $(".input-frame-Css");    /*获取输入框类*/
            let theadValues = $(".table").children('thead').find('tr').children('th');/*获取展示表的字段*/
            theadValues.each(function (key, value) {
                let json = {};
                json.name = $(value).html();
                if ($(value).is('.updateInvalid')) {
                    json.readonly = true;
                }
                if ($(value).is(".singleBox")) {
                    json.type = "radio";
                } else {
                    json.type = "text";    // 防止type无参数
                }
                json.value = "";
                field.push(json);
            });
            field.shift();   //去掉头部键值对参数(全选)
            field.pop();     //去掉尾部参数(操作)
            //装填数据后再进行修输入框样式
            console.log(field)
            openInputFrame(input_frame, $('.overlap'), field)    // 打开动态输入框
            if ($(".form-content:has(.form-group)").length > 0) {
                valAddition(field); //添加值
            }else {
                dynamicInputBox(field, input_frame);    //创建输入框,且添加值
            }
            //  设置数据提交路径
            $('.submitData').attr('targetHref', ($(this).attr('targetHref')))
        });
        /*add end*/
    });
})(jQuery);