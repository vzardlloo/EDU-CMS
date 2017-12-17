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
<body  class="layui-bg-cyan">
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this">学生登录</li>
        <li>教师登录</li>
        <li>管理员</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
         <div class="login">
         <h1>学生登录入口</h1>
        <form class="layui-form">
            <div class="layui-form-item">
                <input class="layui-input" name="username" placeholder="用户名" value="admin" lay-verify="required" type="text" autocomplete="off">
            </div>
            <div class="layui-form-item">
                <input class="layui-input" name="password" placeholder="密码" value="admin"  lay-verify="required" type="password" autocomplete="off">
            </div>
            <div class="layui-form-item form_code">
                <input class="layui-input" style="width: 140px;" name="captcha" placeholder="验证码" lay-verify="required" type="text" autocomplete="off">
                <div class="code"><img id="captcha" src="/captcha" width="116" height="36" onclick="this.src='/captcha.html?'+Math.random();"  cursor:pointer;" alt="captcha"></div>
            </div>
            <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
        </form>
        </div>
        </div>
        <div class="layui-tab-item">
            <div class="login">
                <h1>教师登录入口</h1>
                <form class="layui-form">
                    <div class="layui-form-item">
                        <input class="layui-input" name="username" placeholder="用户名" value="admin" lay-verify="required" type="text" autocomplete="off">
                    </div>
                    <div class="layui-form-item">
                        <input class="layui-input" name="password" placeholder="密码" value="admin"  lay-verify="required" type="password" autocomplete="off">
                    </div>
                    <div class="layui-form-item form_code">
                        <input class="layui-input" style="width: 140px;" name="captcha" placeholder="验证码" lay-verify="required" type="text" autocomplete="off">
                        <div class="code"><img id="captcha" src="/captcha.html" width="116" height="36" onclick="this.src='/captcha.html?'+Math.random();"  cursor:pointer;" alt="captcha"></div>
                    </div>
                    <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
                </form>
            </div>
        </div>
        <div class="layui-tab-item">
            <div class="login">
                <h1>管理员登录入口</h1>
                <form class="layui-form">
                    <div class="layui-form-item">
                        <input class="layui-input" name="username" placeholder="用户名" value="admin" lay-verify="required" type="text" autocomplete="off">
                    </div>
                    <div class="layui-form-item">
                        <input class="layui-input" name="password" placeholder="密码" value="admin"  lay-verify="required" type="password" autocomplete="off">
                    </div>
                    <div class="layui-form-item form_code">
                        <input class="layui-input" style="width: 140px;" name="captcha" placeholder="验证码" lay-verify="required" type="text" autocomplete="off">
                        <div class="code"><img id="captcha" src="/captcha.html" width="116" height="36" onclick="this.src='/captcha.html?'+Math.random();"  cursor:pointer;" alt="captcha"></div>
                    </div>
                    <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
                </form>
            </div>
        </div>
    </div>
    </div>




<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        console.assert(element)
        //…
    });
</script>


</body>
</html>