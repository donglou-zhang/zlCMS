<!DOCTYPE html>
<!-- saved from url=(0072)http://www.jq22.com/demo/bootstrap-login-forms20160328/form-1/index.html -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>

    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/home/sign/login_form-elements.css">
    <link rel="stylesheet" href="/css/home/sign/login_style.css">
    <link rel="stylesheet" href="/css/home/sign/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
	<!--<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>-->
	<!--<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>-->
    <![endif]-->
</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Zhanglei</strong>  Blog</h1>
                    <div class="description">
                        <p>
                            <font style="font-style: italic">"The tiger in the heart of the rose!"</font>   ——Siegfried Sassoon
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Login to my blog</h3>
                            <p>Not yet registered? Go to <a href = "/signup">register</a></p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/signin" method="post" class="login-form" id="#signinForm">
                            <div class="form-group">
                                <label class="sr-only" for="username">Username</label>
                                <input type="text" name="username" placeholder="Username" class="form-username form-control" id="username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="password">Password</label>
                                <input type="password" name="password" placeholder="Password" class="form-password form-control" id="password">
                            </div>
                            <div class="checkbox remember-me">
                                <label for="remember-me">
                                <input type="checkbox" name="remember-me" id="remember-me">记住我
                                </label>
                            </div>
                            <#if Session.SPRING_SECURITY_LAST_EXCEPTION??>
                                <span class="error">登录失败,请重试</span>
                            </#if>
                            <button type="submit" class="btn">Sign in!</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                    <h3>其他方式登录</h3>
                    <div class="social-login-buttons">
                        <a class="btn btn-link-1 btn-link-1-qq" href="">
                            <i class="fa fa-qq"></i> QQ
                        </a>
                        <a class="btn btn-link-1 btn-link-1-weixin" href="">
                            <i class="fa fa-weixin"></i> 微信
                        </a>
                        <a class="btn btn-link-1 btn-link-1-weibo" href="">
                            <i class="fa fa-weibo"></i> 微博
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- Javascript -->
<script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>
<script type="text/javascript">

    jQuery(document).ready(function() {

        /*
            Fullscreen background
        */
        $.backstretch("/images/home/login_background.jpg");

        /*
            Form validation
        */
        $("#signinForm").validate({
            rules: {
                username: {
                    required: true
                },
                password: {
                    required: true
                }
            }
        });

        $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
            $(this).removeClass('input-error');
        });

        $('.login-form').on('submit', function(e) {

            $(this).find('input[type="text"], input[type="password"], textarea').each(function(){
                if( $(this).val() == "" ) {
                    e.preventDefault();
                    $(this).addClass('input-error');
                }
                else {
                    $(this).removeClass('input-error');
                }
            });

        });


    });
</script>



<#--<div class="backstretch" style="left: 0px; top: 0px; overflow: hidden; margin: 0px; padding: 0px; height: 721px; width: 1423px; z-index: -999999; position: fixed;">-->
	<#--<img src="./Bootstrap Login Form Template_files/1.jpg" style="position: absolute; margin: 0px; padding: 0px; border: none; width: 1423px; height: 948.667px; max-height: none; max-width: none; z-index: -999999; left: 0px; top: -113.833px;">-->
<#--</div>-->
</body>
</html>