<div class="layui-body">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px">
        <legend>查看成绩</legend>
    </fieldset>
    <table class="layui-table" lay-data="{height: 'full-200', url:'/student/course/${student.getNumber()}', page:true, id:'course'}" lay-filter="demo">
        <thead>
        <tr>
            <!--th lay-data="{type:'checkbox', fixed: 'left'}"></th-->
            <th lay-data="{field:'number', width:80}">课程号</th>
            <th lay-data="{field:'name', width:80}">课程名</th>
            <th lay-data="{field:'credit', width:80}">学分</th>
            <th lay-data="{field:'period', width:80}">课时</th>
            <th lay-data="{field:'teacher', width:80}">教师</th>
            <th lay-data="{field:'time', width:120}">上课时间</th>
            <th lay-data="{field:'classroom', width:120}">上课教室</th>
            <th lay-data="{field:'pacificGrade', width:120}">平时成绩</th>
            <th lay-data="{field:'paperGrade', width:120}">卷面成绩</th>
            <th lay-data="{field:'overallGrade', width:120}">总评成绩</th>

        </tr>
        </thead>
    </table>


</div>