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
    <title>${article.title}</title>
</head>
<body>
<div class="container page">
    <div class="row">
        <!-- 包括introduce区以及导航区 -->
        <div class="col-sm-12 col-md-12 header">
            <#include "assembly/header.ftl" >
            <#include "assembly/navbarWithoutKind.ftl" >
        </div>
    </div>
    <div class="row">
        <!-- 正文区 -->
        <div class="col-sm-12 col-md-12 remove_padding">
            <div class="main">
                <div class="content col-sm-12 col-md-12 remove_padding" id="brief_intro">
                    <div class="article_info">
                        <div class="article_content_label">
                            <span class="article_title">${article.title}</span>
                            <span class="article_time"><small>&nbsp;&nbsp;(${article.updateTime})&nbsp;&nbsp;</small></span>
                            <#if article.topic?exists>
                                <#if article.topic!="">
                                    <span class="label label-info arrowed-in-right arrowed"><small>${article.topic}</small></span>
                                </#if>
                            </#if>
                        </div>
                        <div class="article_content">
                            ${article.content}
                        </div>
                        <div class="article_link">
                            <ul>
                                <#if preArticle??>
                                    <li>前一篇：<a href="http://127.0.0.1:8088/article?id=${preArticle.id}&kind=${kind}">${preArticle.title}</a></li>
                                </#if>

                                <#if nextArticle??>
                                    <li>后一篇：<a href="http://127.0.0.1:8088/article?id=${nextArticle.id}&kind=${kind}">${nextArticle.title}</a></li>
                                </#if>
                            </ul>
                        </div>
                        <div class="article_comment">
                            <div class="comments_label">
                                评论
                            </div>
                            <div class="comments">
                                <#list comments as comment>
                                    <div class="col-md-1 glyphicon glyphicon-user comment_avatar"></div>
                                    <div class="col-md-1 comment_username">${comment.user.username}</div>
                                    <div class="col-md-10 comment_words">${comment.comment_text}</div>
                                </#list>
                            </div>
                            <div class="comments_label">
                                发评论
                            </div>
                            <div class="make_comments">
                                <form action="/admin/comment" method="POST" accept-charset="utf-8">
                                    <#if user_id??>
                                        <input type="hidden" name="user_id" value="${user_id}" />
                                    </#if>
                                    <#if article.id??>
                                        <input type="hidden" name="article_id" value="${article.id}" />
                                    </#if>
                                    <div class="form-group">
                                        <#if username??>
                                            <textarea type="text" class="form-control" name="comment" id="comment">${username}:</textarea>
                                        <#else>
                                            <label class="warn_submit_comment" for="comment_content">还没登陆，请登陆后评论!</label>
                                            <textarea type="text" class="form-control" name="comment_content" id="comment_content"></textarea>
                                        </#if>
                                        <#--<label class="submit_comment" for="comment_content">${sessionScope.user.username }:</label>-->

                                    </div>
                                    <#if username??>
                                        <button type="submit" class="btn btn-default">提交</button>
                                    <#else>
                                        <button type="submit" class="btn btn-default" disabled="disabled">提交</button>
                                    </#if>

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