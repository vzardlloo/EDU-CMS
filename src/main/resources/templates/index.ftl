<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!--author:lucailei-->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>AHUT</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!---粘页脚-->
    <style type="text/css">
        /* Sticky footer styles
     -------------------------------------------------- */

        html,
        body {
            height: 100%;
            /* The html and body elements cannot have any padding or margin. */
        }

        /* Wrapper for page content to push down footer */
        #wrap {
            min-height: 100%;
            height: auto !important;
            height: 100%;
            /* Negative indent footer by it's height */
            margin: 0 auto -60px;
        }

        /* Set the fixed height of the footer here */
        #push,
        #footer {
            height: 60px;
        }
        #footer {
            background-color: #f5f5f5;
        }

        /* Lastly, apply responsive CSS fixes as necessary */
        @media (max-width: 767px) {
            #footer {
                margin-left: -20px;
                margin-right: -20px;
                padding-left: 20px;
                padding-right: 20px;
            }
        }



        /* Custom page CSS
        -------------------------------------------------- */
        /* Not required for template or sticky footer method. */

        .container {
            width: auto;
            max-width: 680px;
        }
        .container .credit {
            margin: 20px 0;
        }



        /* Carousel base class */
        .carousel {
            margin-bottom: 60px;
        }

        .carousel .container {
            position: relative;
            z-index: 9;
        }

        .carousel-control {
            height: 80px;
            margin-top: 0;
            font-size: 120px;
            text-shadow: 0 1px 1px rgba(0,0,0,.4);
            background-color: transparent;
            border: 0;
            z-index: 10;
        }

        .carousel .item {
            height: 500px;
        }
        .carousel img {
            position: absolute;
            top: 0;
            left: 0;
            min-width: 100%;
            height: 500px;
        }

        .carousel-caption {
            background-color: transparent;
            position: static;
            max-width: 550px;
            padding: 0 20px;
            margin-top: 200px;
        }
        .carousel-caption h1,
        .carousel-caption .lead {
            margin: 0;
            line-height: 1.25;
            color: #fff;
            text-shadow: 0 1px 1px rgba(0,0,0,.4);
        }
        .carousel-caption .btn {
            margin-top: 10px;
        }

        @media (max-width: 979px) {

            .container.navbar-wrapper {
                margin-bottom: 0;
                width: auto;
            }
            .navbar-inner {
                border-radius: 0;
                margin: -20px 0;
            }

            .carousel .item {
                height: 500px;
            }
            .carousel img {
                width: auto;
                height: 500px;
            }

            .featurette {
                height: auto;
                padding: 0;
            }
            .featurette-image.pull-left,
            .featurette-image.pull-right {
                display: block;
                float: none;
                max-width: 40%;
                margin: 0 auto 20px;
            }
        }


        @media (max-width: 767px) {

            .navbar-inner {
                margin: -20px;
            }

            .carousel {
                margin-left: -20px;
                margin-right: -20px;
            }
            .carousel .container {

            }
            .carousel .item {
                height: 300px;
            }
            .carousel img {
                height: 300px;
            }
            .carousel-caption {
                width: 65%;
                padding: 0 70px;
                margin-top: 100px;
            }
            .carousel-caption h1 {
                font-size: 30px;
            }
            .carousel-caption .lead,
            .carousel-caption .btn {
                font-size: 18px;
            }

            .marketing .span4 + .span4 {
                margin-top: 40px;
            }

            .featurette-heading {
                font-size: 30px;
            }
            .featurette .lead {
                font-size: 18px;
                line-height: 1.5;
            }

        }

    </style>





</head>
<body>

<nav class="navbar  navbar-inverse navbar-fixed-top" style="margin-bottom:0px;background-color: #16181b;border-color: #16181b;border-radius: 0px">
    <div class="container-fluid" >
        <div class="row">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">&nbsp;&nbsp;&nbsp;MY-CMS</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <div class="col-md-10">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/login">登录</a></li>
                        <li><a href="/register">注册</a></li>
                    </ul>
                </div>
                <div class="col-md-2"></div>

            </div><!-- /.navbar-collapse -->
        </div>
    </div><!-- /.container-fluid -->
</nav>


<!-- Wrapper for slides -->
<div id="myCarousel" class="carousel slide" style="margin-bottom: 0px">
    <div class="carousel-inner">
        <div class="item active">
            <img src="/banner1.jpg" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Example headline.</h1>
                    <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <a class="btn btn-large btn-primary" href="#">Sign up today</a>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/banner2.jpg" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Another example headline.</h1>
                    <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <a class="btn btn-large btn-primary" href="#">Learn more</a>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/banner3.jpg" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>One more for good measure.</h1>
                    <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <a class="btn btn-large btn-primary" href="#">Browse gallery</a>
                </div>
            </div>
        </div>
    </div>
    <!--a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a-->
</div><!-- /.carousel -->

<div class="container-fluid" style="margin: 0px;margin-right: 0px;max-width: none">
    <div class="row">
    <div class="col-md-5 " style="padding: 0px">
        <img src="/airplane.svg">
    </div>
    <div class="col-md-7" style="padding: 0px">
        <div class="col-md-2"></div>
        <div class="col-md-10" style="padding: 25px">
            <h1>MY-CMS</h1>
            <p>welcome to my-cms,this a tiny cms which build by springboot/joop/bootstrap</p>
            <p>hava fun,I will make it prefect it soon :-)</p>
        </div>
    </div>
    </div>
</div>


<!--页脚-->
<div class="navbar navbar-fix-buttom"  style="position: relative;background-color: #1b1e21;border-radius: 0px;margin-bottom: 0px">
    <div class="container">
        <p class="muted credit" style="color: #f8f9fa">create by vzardlloo♥2017</p>
    </div>
</div>
<!--页脚结束-->



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $('.carousel').carousel('cycle');
</script>
</body>
</html>
