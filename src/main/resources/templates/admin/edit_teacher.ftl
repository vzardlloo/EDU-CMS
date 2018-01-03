<div class="layui-body">
    <form class="layui-form"  style="padding: 15px">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px">
            <legend>编辑教师信息</legend>
        </fieldset>

        <table class="layui-table" lay-data="{height: 'full-200', url:'/admin/teacher', page:true, id:'teacherList'}" lay-filter="teacherList">
            <thead>
            <tr>
                <!--th lay-data="{type:'checkbox', fixed: 'left'}"></th-->
                <th lay-data="{field:'number'}">工号</th>
                <th lay-data="{field:'name',edit: 'text'}">姓名</th>
                <th lay-data="{field:'password',edit: 'text'}">密码</th>
                <th lay-data="{field:'gender',edit: 'text'}">性别</th>
                <th lay-data="{field:'office',edit: 'text'}">办公室</th>
                <th lay-data="{field:'academy',edit: 'text'}">学院</th>
                <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#postTeacher'}"></th>
            </tr>
            </thead>
        </table>
        <script type="text/html" id="postTeacher">
            <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="post">保存</a>
            <!--a class="layui-btn layui-btn-xs" lay-event="edit">选课</a-->
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>


    </form>

</div>