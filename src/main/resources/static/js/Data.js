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
        $(".SingleModify").on('click', function () {
            // $.post("/student/ToUpdate", {ID: $(this).attr('value')})
            window.location.href="/student/ToUpdate/"+$(this).attr('value');

        })

        function paramsJump(Params, URL, Type, targetUrl) {
            $.ajax({
                type: Type, //提交方式
                // dataType: "json",    //指定返回的数据类型
                url: URL,//路径
                data: {
                    "data": Params
                },//数据
                async: false,
                success: function (result) {//返回数据根据结果进行相应的处理
                    if (result === 'ok') {
                        window.location.href = targetUrl
                    } else {
                        window.alert(result);
                    }
                },
                error: function (result) {
                    window.alert("数据无法找到" + result);
                }
            });
        }

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


    }

)(jQuery);

