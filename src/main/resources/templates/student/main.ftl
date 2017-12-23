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
    layui.use(['form', 'layedit', 'laydate','jquery'], function(){
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
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
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

        form.on('submit(*)',function (data) {
                $.ajax({
                    type: 'POST',
                    url: "/student/update",
                    data: JSON.stringify(data.field),
                    dataType: 'json',
                    contentType: "application/json",
                    success: function () {
                        layer.msg("修改成功！", {icon: 6})
                    },
                    error: function () {
                        layer.msg("修改失败！", {icon: 5})
                    }


            });

            return false;
    });

   });

    
    //======choose Js==============//
    layui.use('table', function(){
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                //layer.msg('ID：'+ data.id + ' 的查看操作');
                var data2 = {"courseNum":data.number,"studentNum":data.studentNumber}
                $.ajax({
                    type:'POST',
                    url:'/student/course',
                    data:JSON.stringify(data2),
                    dataType: 'json',
                    contentType: "application/json",
                    success: function () {
                        layer.msg("选课成功！", {icon: 6})
                        //$.("#choose").disable()
                    },
                    error: function () {
                        layer.msg("选课失败！", {icon: 5})
                    }
                })

            } else if(obj.event === 'del'){
                layer.confirm("确定退课？", function(index){
                    var data2 = {"courseNum":data.number,"studentNum":data.studentNumber}
                    $.ajax({
                        type:'DELETE',
                        url:'/student/course',
                        data:JSON.stringify(data2),
                        dataType: 'json',
                        contentType: "application/json",
                        success: function () {
                            layer.msg("退课成功！", {icon: 6})

                        },
                        error: function () {
                            layer.msg("退课失败！", {icon: 5})
                        }
                    })
                });
            } else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data.name))
            }
        });

        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
                var checkStatus = table.checkStatus('course')
                        ,data = checkStatus.data;
                //layer.alert(JSON.stringify(data[0].number+"::"+data[0].studentNumber));
                var data2 = {"courseNum":data[0].number,"studentNum":data[0].studentNumber}
                $.ajax({
                    type:'POST',
                    url:'/student/course',
                    data:JSON.stringify(data2),
                    dataType: 'json',
                    contentType: "application/json",
                    success: function () {
                        layer.msg("选课成功！", {icon: 6})
                    },
                    error: function () {
                        layer.msg("选课失败！", {icon: 5})
                    }


                })

            }
            ,getCheckLength: function(){ //获取选中数目
                var checkStatus = table.checkStatus('course')
                        ,data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
            }
            ,isAll: function(){ //验证是否全选
                var checkStatus = table.checkStatus('course');
                layer.msg(checkStatus.isAll ? '全选': '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });



</script>






</body>
</html>