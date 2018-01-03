<div class="layui-body">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px">
        <legend>发布成绩</legend>
    </fieldset>
    <table class="layui-table" lay-data="{height: 'full-200', url:'/teacher/grade/${teacher.getNumber()}', page:true, id:'grade'}" lay-filter="grade">
        <thead>
        <tr>
            <!--th lay-data="{type:'checkbox', fixed: 'left'}"></th-->
            <th lay-data="{field:'number'}">学号</th>
            <th lay-data="{field:'name'}">姓名</th>
            <th lay-data="{field:'courseNum'}">课程号</th>
            <th lay-data="{field:'courseName'}">课程名</th>
            <th lay-data="{field:'pacificGrade',edit: 'text'}">平时成绩</th>
            <th lay-data="{field:'paperGrade',edit: 'text'}">卷面成绩</th>
            <th lay-data="{field:'overallGrade',edit: 'text'}">总评成绩</th>
            <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#postGrade'}"></th>
        </tr>
        </thead>
    </table>

    <script type="text/html" id="postGrade">
        <a id = "choose" class="layui-btn layui-btn-primary layui-btn-xs" lay-event="post">发布</a>
        <!--a class="layui-btn layui-btn-xs" lay-event="edit">选课</a-->
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="reset">重置</a>
    </script>

</div>