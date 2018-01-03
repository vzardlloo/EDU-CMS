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
<body class="layui-layout-body">
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

    });

    //=======================
    layui.use(['form', 'layedit', 'laydate','jquery','table'], function(){
        var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;
        var $ = layui.jquery

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            notNull: function(value){
                if(value.length == 0){
                    return '此字段非空！';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,content: function(value){
                layedit.sync(editIndex);
            }
            ,regPwd: function (value) {
                var pwd = $("#password").val();
                var regPwd = $("#password2").val();
                if(pwd != regPwd){
                    return "两次密码输入不一致!"
                }
            }

        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        form.on('submit(student)',function (data) {
            $.ajax({
                type: 'POST',
                url: "/admin/student",
                data: JSON.stringify(data.field),
                dataType: 'json',
                contentType: "application/json",
                success: function () {
                    layer.msg("新建成功！", {icon: 6},function () {
                        refresh();
                    })
                },
                error: function () {
                    layer.msg("新建失败！", {icon: 5})
                }
            });

            return false;
        });

        form.on('submit(teacher)',function (data) {
            $.ajax({
                type: 'POST',
                url: "/admin/teacher",
                data: JSON.stringify(data.field),
                dataType: 'json',
                contentType: "application/json",
                success: function () {
                    layer.msg("新建成功！", {icon: 6},function () {
                        refresh();
                    })
                },
                error: function () {
                    layer.msg("新建失败！", {icon: 5})
                }
            });

            return false;
        });

        var table = layui.table;
        table.on('tool(studentList)',function (obj) {
            var value = obj.value //得到修改后的值
                    ,data = obj.data //得到所在行所有键值
                    ,field = obj.field; //得到字段
            if (obj.event === 'post'){
                $.ajax({
                    type:'PUT',
                    url:'/admin/student',
                    data:JSON.stringify(data),
                    dataType: 'json',
                    contentType: "application/json",
                    success:function () {
                        layer.msg("保存成功",{icon:6},function () {
                            refresh();
                        });

                    },
                    error:function () {
                        layer.msg("保存失败！",{icon:5},function () {
                            refresh();
                        })
                    }

                })
            }else if (obj.event === 'del'){

                $.ajax({
                    type:'DELETE',
                    url:'/admin/student/'+ data.number,
                    dataType: 'json',
                    contentType: "application/json",
                    success:function (res) {
                        layer.msg("删除成功！", {icon: 6},function () {
                            refresh();
                        });
                    },
                    error:function () {
                        layer.msg("删除失败！",{icon:5},function () {

                        })
                    }
                })

            }
        });


        table.on('tool(teacherList)',function (obj) {
            var value = obj.value //得到修改后的值
                    ,data = obj.data //得到所在行所有键值
                    ,field = obj.field; //得到字段
            if (obj.event === 'post'){
                $.ajax({
                    type:'PUT',
                    url:'/admin/teacher',
                    data:JSON.stringify(data),
                    dataType: 'json',
                    contentType: "application/json",
                    success:function () {
                        layer.msg("保存成功",{icon:6},function () {
                            refresh();
                        });

                    },
                    error:function () {
                        layer.msg("保存失败！",{icon:5},function () {

                        })
                    }

                })
            }else if (obj.event === 'del'){

                $.ajax({
                    type:'DELETE',
                    url:'/admin/teacher/'+ data.number,
                    dataType: 'json',
                    contentType: "application/json",
                    success:function (res) {
                        layer.msg("删除成功！", {icon: 6},function () {
                            refresh();
                        });
                    },
                    error:function () {
                        layer.msg("删除失败！",{icon:5},function () {

                        })
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