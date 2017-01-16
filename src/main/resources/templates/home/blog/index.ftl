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
								<#--<span class="badge">旅游</span>	-->
								<#--<span class="badge">编程</span>-->
								<#--<span class="badge">健身</span>	-->
								<#--<span class="badge">北航</span>-->
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
			           		 <li class="active">
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
					<div class="content col-sm-9 col-md-9 remove_padding" id="brief_intro">
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
                                    <a href="/article?id=${article.id}" target="_blank">查看全文>></a>
                                </div>
                            </div>
						</#list>
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