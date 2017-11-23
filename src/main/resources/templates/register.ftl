<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>

    <!--CSS-->

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/login/form-elements.css">
    <link rel="stylesheet" href="/css/login/style.css">


    <!--Favicon and touch icons -->
    <link rel="shortcut icon" href="../static/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/ico/apple-touch-icon-57-precomposed.png">

    <!-- JS -->
    <script type="application/javascript">
        function check() {
           var password = document.getElementById("password");
           var passwordAg = document.getElementById("passwordagain");
           if (password != passwordAg) {
                alert("两次密码输入不一致!")
           }
        }








    </script>

</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1>Register Form</h1>
                    <div class="description">
                        <p>
                            Welcome to register to our site!
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Register to our site</h3>
                            <p>Enter your information to register in:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" id="register-form" action="register" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Number</label>
                                <input name="number" type="text"  placeholder="Number..." class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input name="name" type="text"  placeholder="Name..." class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input name="password" id="password" type="password"  placeholder="Password..." class="form-password form-control" id="form-password">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password again</label>
                                <input type="password" id="passwordagain"  placeholder="Password again..." class="form-password form-control" id="form-password">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Brithday</label>
                                <input name="brithday" type="text" name="form-password" placeholder="Brithday" class="form-password form-control" id="form-password">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Address</label>
                                <input name="address" type="text"  placeholder="Address" class="form-password form-control" id="form-password">
                            </div>

                            <div class="form-group">
                                <label class="sr-only" for="form-password">Phone</label>
                                <input name="phoneNumber" type="text"  placeholder="Phone" class="form-password form-control" id="form-password">
                            </div>

                            <label class="radio-inline">
                                <input type="radio" style="width: 20px;height: 20px;margin-bottom: 10px" name="gender" id="inlineRadio1" value="Male">Male
                            </label>
                            <label class="radio-inline" style="margin-left: 50px;width: 20px;height: 20px;margin-bottom: 10px">
                                <input type="radio" style="width: 20px;height: 20px" name="gender" id="inlineRadio2" value="Female">Female
                            </label>

                            <button type="submit" onclick="check()" class="btn">Register in!</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                    <h3>...or register with:</h3>
                    <div class="social-login-buttons">
                        <a class="btn btn-link-1 btn-link-1-facebook" href="#">
                            <i class="fa fa-facebook"></i> Facebook
                        </a>
                        <a class="btn btn-link-1 btn-link-1-twitter" href="#">
                            <i class="fa fa-twitter"></i> Twitter
                        </a>
                        <a class="btn btn-link-1 btn-link-1-google-plus" href="#">
                            <i class="fa fa-google-plus"></i> Google Plus
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>




<!-- javascript-->
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="/js/login/jquery.backstretch.min.js"></script>
<script src="/js/login/scripts.js"></script>
<!-- 表单验证插件 -->
<script src="https://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="https://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>

<!--[if lt IE 10]>
<script src="/js/login/placeholder.js."></script>
<![endif]-->

</body>

</html>