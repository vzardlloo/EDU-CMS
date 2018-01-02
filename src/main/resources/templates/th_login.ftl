    <div class="login">
        <h1>教师登录入口</h1>
        <form class="layui-form" action="/teacher/main" method="post">
            <div class="layui-form-item">
                <input class="layui-input" name="number" value="0001" placeholder="工号"  lay-verify="required" type="text" autocomplete="off">
            </div>
            <div class="layui-form-item">
                <input class="layui-input" name="password" value="12345" placeholder="密码"   lay-verify="required" type="password" autocomplete="off">
            </div>
            <div class="layui-form-item form_code">
                <input class="layui-input" style="width: 140px;" name="verifycode" placeholder="验证码"  lay-verify="required" type="text" autocomplete="off">
                <div class="code"><img id="captcha" src="/captcha.html" width="116" height="36" onclick="this.src='/captcha.html?'+Math.random();"  cursor:pointer;" alt="captcha"></div>
            </div>
            <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
        </form>
    </div>
