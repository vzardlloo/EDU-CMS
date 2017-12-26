<div class="layui-body">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px">
        <legend>选课/退课</legend>
    </fieldset>
    <table class="layui-table" lay-data="{height: 'full-200', url:'/student/courselist/${student.getNumber()}', page:true, id:'course'}" lay-filter="demo">
        <thead>
        <tr>
            <!--th lay-data="{type:'checkbox', fixed: 'left'}"></th-->
            <th lay-data="{field:'id', width:40, sort: true, fixed: true}">ID</th>
            <th lay-data="{field:'number', width:80}">课程号</th>
            <th lay-data="{field:'name', width:80}">课程名</th>
            <th lay-data="{field:'credit', width:80}">学分</th>
            <th lay-data="{field:'period', width:80}">课时</th>
            <th lay-data="{field:'teacher', width:80}">教师</th>
            <th lay-data="{field:'time', width:120}">上课时间</th>
            <th lay-data="{field:'classroom', width:120}">上课教室</th>
            <th lay-data="{field:'maxChoosed', width:120}">最大容量</th>
            <th lay-data="{field:'hasChoosed', width:120}">已选人数</th>
            <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
        </tr>
        </thead>
    </table>

    <script type="text/html" id="barDemo">
        <a id = "choose" class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">选课</a>
        <!--a class="layui-btn layui-btn-xs" lay-event="edit">选课</a-->
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">退课</a>
    </script>




</div>