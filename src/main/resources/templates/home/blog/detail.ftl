<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="/css/home/blog/common.css" rel="stylesheet">
    <link href="/css/home/blog/ihover.css" rel="stylesheet">
    <link href="/css/home/blog/docs.min.css" rel="stylesheet">
    <link href="/css/home/blog/article.css" rel="stylesheet">
    <title>博文</title>
</head>
<body>
<div class="container page">
    <div class="row">
        <!-- 包括introduce区以及导航区 -->
        <div class="col-sm-12 col-md-12 header">
            <div class="introduce">
                <div class="logo">
                    <div class="col-sm-4 col-md-4 col-sm-offset-4 col-md-offset-4">
                        <div class="ih-item circle effect2 left_to_right  margin_auto">
                            <a href="#">
                                <div class="img">
                                    <img src="/images/home/avatar.jpg" alt="img">
                                </div>
                                <div class="info">
                                    <h3>Zhanglei Blog</h3>
                                    <p>Welcome</p>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="label_area">
                    <div class="col-sm-4 col-md-4 col-sm-offset-4 col-md-offset-4">
                        <div class="self_label margin_auto">
                        <#list labels as label>
                            <span class="badge">${label}</span>
                        </#list>
                        </div>
                    </div>
                </div>
            </div>
            <div class="navbar navbar-static-top bs-docs-nav menu">
                <div class="col-sm-offset-4 col-md-offset-4 col-sm-8 col-md-8 menu_bar">
                    <div class="navbar-header">
                        <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#bs-navbar" aria-controls="bs-navbar" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <nav id="bs-navbar" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="/blog/index">首页</a>
                            </li>
                            <li>
                                <a href="/blog/coding">编程</a>
                            </li>
                            <li>
                                <a href="/blog/reading">读书</a>
                            </li>
                            <li>
                                <a href="/blog/essay">随笔</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right login_area">
                        <#if username??>
                            <li><span style="color: #FFFFFF">你好，${username}</span></li>
                            <#if authority_num == 2>
                                <li><span><a href="/admin/index" target="_blank" style="color: #a20b0b">控制台</a></span></li>
                            </#if>
                            <li><a href="/logout">退出</a></li>
                        <#else>
                            <li><a href="/signin"">登陆</a></li>
                            <li><a href="/signup">注册</a></li>
                        </#if>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <!-- 包括左侧边栏区以及正文区 -->
        <div class="col-sm-12 col-md-12 remove_padding">
            <div class="main">
                <div class="content col-sm-12 col-md-12 remove_padding" id="brief_intro">
                    <div class="article_info">
                        <div class="article_content_label">
                            <span class="article_title">article.title</span>
                            <span class="article_time"><small>&nbsp;&nbsp;(article.updateTime)</small></span>
                        </div>
                        <div class="article_content">
                            article.summary
                        </div>
                        <div class="article_link">
                            <ul>
                                <li>前一篇：<a href="#">Pre</a></li>
                                <li>后一篇：<a href="#">Next</a></li>
                            </ul>
                        </div>
                        <div class="article_comment">
                            <div class="comments_label">
                                评论
                            </div>
                            <div class="comments">
                                <div class="single_comment row">
                                    <div class="col-md-1 glyphicon glyphicon-user comment_avatar"></div>
                                    <div class="col-md-1 comment_username">张磊</div>
                                    <div class="col-md-10 comment_words">这是一篇不错的博文,嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿</div>
                                </div>
                                <div class="single_comment row">
                                    <div class="col-md-1 glyphicon glyphicon-user comment_avatar"></div>
                                    <div class="col-md-1 comment_username">张磊</div>
                                    <div class="col-md-10 comment_words">这是一篇不错的博文,嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿</div>
                                </div>
                            </div>
                            <div class="comments_label">
                                发评论
                            </div>
                            <div class="make_comments">
                                <form action="" method="POST" accept-charset="utf-8">
                                    <input type="hidden" name="user.uid" value="sessionScope.user.uid" />
                                    <input type="hidden" name="article.aid" value="requestScope.currentArticle.aid" />
                                    <div class="form-group">
                                        <label class="warn_submit_comment" for="comment_content">还没登陆，请登陆后评论!</label>
                                        <#--<label class="submit_comment" for="comment_content">${sessionScope.user.username }:</label>-->
                                        <textarea type="text" class="form-control" name="comment_content" id="comment_content"></textarea>
                                    </div>
                                    <button type="submit" class="btn btn-default submit_comment_btn" onclick="">提交</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <!-- 尾部介绍区 -->
        <div class="col-sm-12 col-md-12 footer">
            <div class="foot">
                <ul>
                    <li>当前版本： v0.0.9</li>
                    <li>Copyright © 2016 - ,  All Rights Reserved</li>
                </ul>

            </div>
        </div>
    </div>
</div>
</body>
<script type="text/JavaScript" src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script type="text/JavaScript" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript">

</script>
</html>