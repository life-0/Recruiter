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

        $(".SingleModify").on('click', function () {    //单个编辑 传参
            // $.post("/student/ToUpdate", {ID: $(this).attr('value')})
            window.location.href = "/student/ToUpdate/" + $(this).attr('value');
        });

        $(".submitData").on('click', function () {
            let formObject = {};
            let formArray = $(".form-data").serializeArray();   //将参数序列化
            $.each(formArray, function (i, item) {
                formObject[item.name] = item.value;
            });
            $.ajax({
                url: "/student/Update",
                type: "post",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(formObject),
                success: function (data) {
                    if (data === "ok") {
                        let frame =window.open("/student/tables","_self");
                        // frame.postMessage("a message","/student/tables")
                        // 等该窗口装载完成时，向该窗口发送消息
                        // frame.onload = function () {
                        //     // 向/student/tables页面发送消息
                        //     frame.postMessage("a message","*")
                        // }
                    }
                },
                error: function (e) {
                    alert("错误！！");
                }
            });
        });


        //链接参考:https://blog.csdn.net/life_2/article/details/114487222?spm=1001.2014.3001.5501
        //        https://www.cnblogs.com/Marydon20170307/p/12612921.html
        function data(arr) {
            $.ajax({
                type: "POST", //提交方式
                // dataType: "json",    //指定返回的数据类型
                url: "/student/DeleteStu",//路径
                data: {
                    "data": arr
                },//数据，这里使用的是Json格式进行传输
                async: false,

                success: function (result) {//返回数据根据结果进行相应的处理
                    if (result === 'ok') {
                        window.location.href = "/student/tables"
                    } else {
                        window.alert(result);
                    }
                },
                error: function (result) {
                    window.alert("参数不符合规格!请重试..." + result);
                }
            });
        }

        function DataTransport(data, type, targetUrl, redirectUrl) {
            $.ajax({
                type: type, //提交方式
                // dataType: "json",    //指定返回的数据类型
                url: targetUrl,//路径
                data: {
                    "data": data
                },//数据，这里使用的是Json格式进行传输
                contentType: "application/json; charset=utf-8",
                async: false,
                cache: false,
                processData: false,
                success: function (result) {//返回数据根据结果进行相应的处理
                    if (result === 'ok') {
                        window.location.href = redirectUrl
                    } else {
                        window.alert(result);
                    }
                },
                error: function (result) {
                    window.alert("传输失败,请重试..." + result);
                }
            });
        }
    }

)(jQuery);

