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
<body  class="layui-layout-body">
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->


<div class="layui-layout layui-layout-admin">

    <#include "head.ftl">
    <#include "side.ftl">
    <#include "${page}.ftl">
    <#include "foot.ftl">

</div>


<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        console.assert(element)
        //…
    });




    //======personal Js============//
    layui.use(['form', 'layedit', 'laydate','jquery','table'], function(){
        var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;
        var $ = layui.jquery

        form.on('submit(course)',function (data) {
                $.ajax({
                    type: 'POST',
                    url: "/teacher/course",
                    data: JSON.stringify(data.field),
                    dataType: 'json',
                    contentType: "application/json",
                    success: function () {
                        layer.msg("发布成功！", {icon: 6})
                    },
                    error: function () {
                        layer.msg("发布失败！", {icon: 5})
                    }


            });

            return false;
    });
    //=============================================================


        var table = layui.table;
        table.on('tool(grade)', function(obj){
            var value = obj.value //得到修改后的值
                    ,data = obj.data //得到所在行所有键值
                    ,field = obj.field; //得到字段
           if (obj.event === 'post'){
               $.ajax({
                   type:'POST',
                   url:'/teacher/grade',
                   data:JSON.stringify(data),
                   dataType: 'json',
                   contentType: "application/json",
                   success:function () {
                       layer.msg("发布成功",{icon:6},function () {
                           refresh();
                       });

                   },
                   error:function () {
                       layer.msg("发布失败！",{icon:5})
                   }

               })

           }else if (obj.event === 'reset'){
               data.pacificGrade = 0;
               data.paperGrade = 0;
               data.overallGrade = 0;
               $.ajax({
                   type:'POST',
                   url:'/teacher/grade',
                   data:JSON.stringify(data),
                   dataType: 'json',
                   contentType: "application/json",
                   success:function (res) {
                       layer.msg("重置成功！", {icon: 6},function () {
                           refresh();
                       });
                   },
                   error:function () {
                       layer.msg("重置失败！",{icon:5})
                   }
               })

           }

        });



   });


    //刷新
    function refresh() {
        window.location.reload();
    }



</script>






</body>
</html>