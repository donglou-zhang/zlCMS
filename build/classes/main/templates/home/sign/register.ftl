<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>

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
                            <h3>Register for my blog</h3>
                            <p>Have registered. Back to <a href = "/signin">login</a></p>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/signup" method="post" class="login-form" id="signUpForm">
                            <div class="form-group">
                                <label class="sr-only" for="username">Username</label>
                                <input type="text" name="username" placeholder="Username" class="form-username form-control" id="username" value="${username!""}">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="password" placeholder="Password(min-length: 6)" class="form-password form-control" id="password">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-re-password">Re_Password</label>
                                <input type="password" name="re_password" placeholder="Re-Password" class="form-password form-control" id="re_password">
                            </div>
                            <#if message??>
                                <span class="error">${message}</span>
                            </#if>
                            <button type="submit" class="btn">Sign up</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- Javascript -->
<script type="text/JavaScript" src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script type="text/JavaScript" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/JavaScript" src="https://cdn.bootcss.com/jquery-validate/1.15.1/jquery.validate.min.js"></script>
<script type="text/JavaScript" src="https://cdn.bootcss.com/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>
<script type="text/javascript">
//    $.validator.setDefaults({
//        submitHandler: function() {
//            alert("提交事件!");
//        }
//    });

    $().ready(function() {
        /*
            Fullscreen background
        */
        $.backstretch("/images/home/login_background.jpg");

        /*
            Form validation
        */
        $("#signUpForm").validate({
            rules: {
                username: {
                    required: true,
                    minlength: 3,
                    maxlength: 12
                },
                password: {
                    required: true,
                    minlength: 6
                },
                re_password: {
                    required: true,
                    minlength: 6,
                    equalTo: "#password"
                }
            },
            messages: {
                username: {
                    required: "请输入待注册用户名",
                    minlength: "用户名长度不得少于3个字符",
                    maxlength: "用户名长度不得多于12个字符"
                },
                password: {
                    required: "请输入密码",
                    minlength: "密码长度不得少于6个字符",
                },
                re_password: {
                    required: "请输入确认密码",
                    minlength: "确认密码长度不得少于6个字符",
                    equalTo: "两次密码输入不一致"
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