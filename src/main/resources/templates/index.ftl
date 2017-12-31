<!DOCTYPE html>

<html>
<head>
    <title>MY-CMS</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="/static/images/favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="/css/layui.css">
    <link rel="stylesheet" href="/css/golbal.css">
    <script src="/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/layui.js" type="text/javascript"></script>
</head>
<body  class="layui-bg-cyan" onload="refreshCode()">
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs">MY-CMS</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">

        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="/student">学生登录</a></li>
            <li class="layui-nav-item"><a href="/teacher">教师登录</a></li>
            <li class="layui-nav-item"><a href="/admin">管理员登录</a></li>
        </ul>
    </div>
    <div class="layui-body" style="left: 0px">
            <#include "${page}.ftl">
    </div>



</div>




<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        console.assert(element)
        //…
    });



//    layui.config({
//        base: "js/"
//    }).use(['form', 'layer'], function () {
//        var form = layui.form(),
//                layer = parent.layer === undefined ? layui.layer : parent.layer,
//                $ = layui.jquery;
//        //登录按钮事件
//        form.on("submit(login)", function (data) {
//            var datas = "number=" + data.field.number + "&password=" + data.field.password + "&captcha=" + data.field.verifycode
//            $.ajax({
//                type: "POST",
//                url: "/student/main",
//                data: datas,
//                dataType: "json",
//                success: function (result) {
//                    if (result.code == 0) {//登录成功
//                        //parent.location.href = '/index.html';
//                    } else {
//                        layer.msg(result.msg, {icon: 5});
//                        refreshCode();
//                    }
//                }
//            });
//            return false;
//        })
//    });


    function refreshCode() {
        var verfiycode = document.getElementById("captcha")
        verfiycode.src = '/captcha.html?'+Math.random();
    }


</script>


</body>
</html>