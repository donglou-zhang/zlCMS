<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>管理员配置</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/admin/ace/font-awesome.min.css" rel="stylesheet">
    <link href="/css/admin/ace/ace.min.css" rel="stylesheet">
    <link href="/css/admin/ace/ace-skins.min.css" rel="stylesheet">
    <!--[if IE 7]>
    <link href="/css/admin/ace/font-awesome-ie7.min.css" rel="stylesheet" />
    <![endif]-->
    <script src="/js/admin/ace/ace-extra.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
</head>

<body>
<#include "assembly/navbar.ftl"><!-- area 1.1 -->
<div class="main-container" id="main-container">
    <div class="row">
        <div class="col-sm-12">

            <div class="breadcrumbs" id="breadcrumbs"><!-- 面包屑导航 -->
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="/admin/index">首页</a>
                    </li>
                    <li class="active">管理员设置</li>
                </ul>
            </div><!-- /.breadcrumbs --> <!-- area 1.2.2.1 -->

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12">
                        <form class="form-horizontal" role="form" id="profileForm" action="/admin/profile" method="post">
                            <div class="form-group">
                                <label class="col-sm-1 control-label no-padding-right" for="avatar">头像</label>
                                <div class="col-sm-11">
                                    <input type="file" id="avatar" name="avatar"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label no-padding-right" for="native_place">籍贯</label>
                                <div class="col-sm-11">
                                    <input type="text" id="native_place" name="native_place" placeholder="籍贯" class="col-xs-6 col-sm-3" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label no-padding-right" for="education">教育</label>
                                <div class="col-sm-11">
                                    <input type="text" id="education" name="education" placeholder="当前学校" class="col-xs-6 col-sm-3" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label no-padding-right" for="studies">研究</label>
                                <div class="col-sm-11">
                                    <input type="text" id="studies" name="studies" placeholder="研究方向" class="col-xs-6 col-sm-3" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label no-padding-right" for="email">邮箱</label>
                                <div class="col-sm-11">
                                    <input type="email" id="email" name="email" placeholder="邮箱" class="col-xs-6 col-sm-3" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label no-padding-right" for="label">标签</label>
                                <div class="col-sm-11">
                                    <input type="text" id="label" name="label" placeholder="标签" class="col-xs-6 col-sm-3" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-1 col-sm-11">
                                    <input class="btn btn-info " type="submit" value="保存">
                                    </input>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div><!-- /.page-content -->
        </div><!-- col-sm-12 -->
    </div><!-- row -->
    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div>

<script type="text/javascript">
    window.jQuery || document.write("<script src='/js/admin/ace/jquery-2.0.3.min.js'>"+"<"+"script>");
</script>

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='/js/admin/ace/jquery.mobile.custom.min.js'>"+"<"+"script>");
</script>

<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/admin/ace/jquery-ui-1.10.3.custom.min.js"></script>
<script src="/js/admin/ace/ace-elements.min.js"></script>
<script src="/js/admin/ace/ace.min.js"></script>
<script type="text/javascript">
    jQuery(function($) {

    })
</script>
</body><!-- area 1 -->
</html>