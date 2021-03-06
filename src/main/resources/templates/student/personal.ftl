<div class="layui-body">
    <form class="layui-form"  style="padding: 15px">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px">
            <legend>修改${student.getName()}的个人信息</legend>
        </fieldset>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" value="${student.getName()}"  autocomplete="off" class="layui-input"  disabled="">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">学号</label>
                <div class="layui-input-inline">
                    <input type="text" name="number" value="${student.getNumber()}" autocomplete="off" class="layui-input" disabled="">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="password" lay-verify="pass" name="password" autocomplete="off" class="layui-input" >
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">重输密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="password2" lay-verify="regPwd"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">生日</label>
                <div class="layui-input-block">
                    <input type="text" value="${student.getBirthday()}" name="birthday" id="date1" autocomplete="off" class="layui-input">
                </div>
            </div>

        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">班级</label>
                <div class="layui-input-inline">
                    <input type="text" value="${student.getClbum()}" name="clbum" autocomplete="off" class="layui-input" >
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">学院</label>
                <div class="layui-input-inline">
                    <input type="text" value="${student.getAcademy()}" name="academy"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <#if "${student.getGender()}" =="男">
                <input type="radio" name="gender" value="男" title="男" checked="">
                <input type="radio" name="gender" value="女" title="女">
                <#elseif "${student.getGender()}" == "女">
                    <input type="radio" name="gender" value="男" title="男">
                    <input type="radio" name="gender" value="女" title="女" checked="">
                </#if>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn"lay-submit="" lay-filter="*">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

</div>