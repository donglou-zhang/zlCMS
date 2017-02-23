<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="/css/home/blog/common.css" rel="stylesheet">
<link href="/css/home/blog/ihover.css" rel="stylesheet">
<link href="/css/home/blog/docs.min.css" rel="stylesheet">
<title>张磊_博客</title>
</head>
<body>
	<div class="container page">
		<div class="row">
			<!-- 包括introduce区以及导航区 -->
			<div class="header col-sm-12 col-md-12">
				<#include "assembly/header.ftl" >
				<#include "assembly/navbar.ftl" >
			</div>
		</div>
		<div class="row">
			<!-- 包括左侧边栏区以及正文区 -->
			<div class="col-sm-12 col-md-12 remove_padding">
				<div class="main">
					<div class="side col-sm-3 col-md-3 remove_padding">
						<div class="personal_information">
							<div class="side_label">
								个人资料
							</div>
							<div class="side_content">
								<#if profile.native_place??>
                                    <div>籍贯： ${profile.native_place}</div>
								</#if>

								<#if profile.education??>
                                    <div>教育： ${profile.education}</div>
								</#if>

								<#if profile.email??>
                                    <div>邮箱： ${profile.email}</div>
								</#if>

								<#if profile.studies??>
                                    <div>研究： ${profile.studies}</div>
								</#if>
							</div>
						</div>
						<div class="blog_topic">
							<div class="side_label">
								博文专题
							</div>
							<div class="side_content">
								<ul>

								</ul>
							</div>
						</div>
					</div>
					<div class="col-sm-9 col-md-9">
						<div class="row">
							<div class="content remove_padding col-sm-12 col-md-12" id="brief_intro">
								<#list articles as article>
									<div class="brief_article">
										<div class="content_label">
											<span class="article_title">${article.title}</span>
											<span class="article_time"><small>&nbsp;&nbsp;(${article.updateTime})</small></span>
										</div>
										<div class="content_introduction">
										${article.summary}
										</div>
										<div class="content_skip">
											<a href="/article?id=${article.id}&kind=${kind}" target="_blank">查看全文>></a>
										</div>
									</div>
								</#list>
							</div>
						</div>
						<div class="row">
							<div class="remove_padding col-sm-12 col-md-12">
                                <button id="loadMore" onclick="load_more()" class="more_article" style="width: 92%; margin-left: 4%;">加载更多</button>
							</div>
						</div>
					</div>
					<#--<div class="content col-sm-9 col-md-9 remove_padding" id="brief_intro">-->
						<#--<#list articles as article>-->
                            <#--<div class="brief_article">-->
                                <#--<div class="content_label">-->
                                    <#--<span class="article_title">${article.title}</span>-->
                                    <#--<span class="article_time"><small>&nbsp;&nbsp;(${article.updateTime})</small></span>-->
                                <#--</div>-->
                                <#--<div class="content_introduction">-->
									<#--${article.summary}-->
                                <#--</div>-->
                                <#--<div class="content_skip">-->
                                    <#--<a href="/article?id=${article.id}&kind=${kind}" target="_blank">查看全文>></a>-->
                                <#--</div>-->
                            <#--</div>-->
						<#--</#list>-->
					<#--</div>-->
                    <#--<div class="col-sm-9 col-md-9 col-sm-offset-3 col-md-offset-3 remove_padding">-->
                        <#--<button id="loadMore" onclick="load_more()" class="more_article" style="width: 92%; margin-left: 4%;">加载更多</button>-->
                    <#--</div>-->
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
		function load_more() {
			current_page += 1;
			$.ajax({
				type: "GET",
				url: "http://127.0.0.1:8088/blog/load_more",
				data: {page: current_page, kind: current_kind},
				dataType: "json",
				success:function(data) {
					if(data.length < 5) {
						$("#loadMore").text("没有更多文章");
					}
					if(data.length > 0) {
                        var append_info = "";
                        data.forEach(function(value, index, array){
                            var info = "<div class='brief_article'><div class='content_label'><span class='article_title'>" + array[index]['title'] + "</span>" +
                                    "<span class='article_time'><small>&nbsp;&nbsp;(" + array[index]['updateTime'] + ")</small></span></div><div class='content_introduction'>" +
                                    array[index]['summary'] + "</div><div class='content_skip'><a href='/article?id=" + array[index]['id'] + "&kind=" + current_kind + "' target='_blank'>查看全文>></a></div></div>";
                            append_info += info;
                        });
                        $("#brief_intro").append(append_info);
					}
				}
			})
        };


</script>
</html>