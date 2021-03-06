<div class="layui-body">
    <form class="layui-form"  style="padding: 15px">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px">
            <legend>新建教师信息</legend>
        </fieldset>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" lay-verify="notNull"  autocomplete="off" class="layui-input"  >
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">工号</label>
                <div class="layui-input-inline">
                    <input type="text" name="number" lay-verify="notNull" autocomplete="off" class="layui-input" >
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="password"  lay-verify="pass" name="password" autocomplete="off" class="layui-input" >
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">办公室</label>
                <div class="layui-input-inline">
                    <input type="text"  name="office" lay-verify="notNull" autocomplete="off" class="layui-input" >
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">学院</label>
                <div class="layui-input-inline">
                    <input type="text"  name="academy" lay-verify="notNull" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="gender" value="男" title="男">
                <input type="radio" name="gender" value="女" title="女">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn"lay-submit="" lay-filter="teacher">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>


    </form>

</div>