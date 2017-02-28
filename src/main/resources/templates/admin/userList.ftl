<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>用户列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/admin/ace/font-awesome.min.css" rel="stylesheet">
    <link href="/css/admin/ace/ace.min.css" rel="stylesheet">
    <link href="/css/admin/ace/ace-skins.min.css" rel="stylesheet">
    <link href="/css/admin/warning.css" rel="stylesheet">
    <!--[if IE 7]>
    <link href="/css/admin/ace/font-awesome-ie7.min.css" rel="stylesheet" />
    <![endif]-->
    <script src="/js/admin/ace/ace-extra.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
</head>

<body>
<#include "assembly/navbar.ftl"><!-- area 1.1 -->
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <#include "assembly/sidebar.ftl"><!-- area 1.2.1 -->
        <div class="main-content">

            <div class="breadcrumbs" id="breadcrumbs"><!-- 面包屑导航 -->
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">首页</a>
                    </li>
                    <li>
                        <a href="#">用户</a>
                    </li>
                    <li class="active">用户列表</li>
                </ul>
            </div><!-- /.breadcrumbs --> <!-- area 1.2.2.1 -->

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12">
                        <div class="widget-box transparent">
                            <div class="widget-header widget-header-flat">
                                <h4 class="lighter">
                                    <i class="icon-star orange"></i>
                                    所有用户
                                </h4>

                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="icon-chevron-up"></i>
                                    </a>
                                </div>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main no-padding">
                                    <table class="table table-bordered table-striped">
                                        <thead class="thin-border-bottom">
                                        <tr>
                                            <th class="center">
                                                <label>
                                                    <input type="checkbox" class="ace" />
                                                    <span class="lbl"></span>
                                                </label>
                                            </th>

                                            <th>
                                                <i class="icon-caret-right blue"></i>
                                                用户名
                                            </th>

                                            <th>
                                                <i class="icon-caret-right blue"></i>
                                                注册时间
                                            </th>

                                            <th>
                                                <i class="icon-caret-right blue"></i>
                                                身份
                                            </th>

                                            <th>
                                                <i class="icon-caret-right blue"></i>
                                                编辑
                                            </th>

                                            <th>
                                                <i class="icon-caret-right blue"></i>
                                                删除
                                            </th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <#list users as user>
                                            <tr>
                                                <td class="center">
                                                    <label>
                                                        <input type="checkbox" class="ace" />
                                                        <span class="lbl"></span>
                                                    </label>
                                                </td>

                                                <td>${user.username}</td>

                                                <td>
                                                    ${user.createTime}
                                                </td>
                                                <#if user.role = "user">
                                                    <td>
                                                        普通用户
                                                    </td>
                                                <#else>
                                                    <td>
                                                        管理员
                                                    </td>
                                                </#if>

                                                <td>
                                                    <button class="btn btn-xs btn-primary" onclick="window.location.href='edit?id=${user.id}'">
                                                        <i class="icon-pencil align-top smaller"></i>
                                                        编辑
                                                    </button>
                                                </td>

                                                <td>
                                                    <button class="btn btn-xs btn-danger" name="${user.id}">
                                                        <i class="icon-trash align-top smaller"></i>
                                                        删除
                                                    </button>
                                                </td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                </div><!-- /widget-main -->
                            </div><!-- /widget-body -->
                        </div><!-- /widget-box -->
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-12">
                        <ul class="pagination pull-left">
                            <li class="prev">
                                <a href="http://127.0.0.1:8088/admin/user/list?page=1">
                                    <i class="icon-double-angle-left"></i>
                                </a>
                            </li>

                            <#if currentPage = 1>
                                <li class="prev disabled">
                                    <a href="http://127.0.0.1:8088/admin/user/list?page=${currentPage-1}">
                                        <i class="icon-angle-left"></i>
                                    </a>
                                </li>
                            <#else>
                                <li class="prev">
                                    <a href="http://127.0.0.1:8088/admin/user/list?page=${currentPage-1}">
                                        <i class="icon-angle-left"></i>
                                    </a>
                                </li>
                            </#if>

                            <#if currentPage gt 1>
                                <li>
                                    <a href="http://127.0.0.1:8088/admin/user/list?page=${currentPage-1}">${currentPage-1}</a>
                                </li>
                            </#if>


                            <li  class="active">
                                <a href="#">${currentPage}</a>
                            </li>

                            <#if currentPage lt maxPage>
                                <li>
                                    <a href="http://127.0.0.1:8088/admin/user/list?page=${currentPage+1}">${currentPage+1}</a>
                                </li>
                            </#if>

                            <#if currentPage+1 gt maxPage>
                                <li class="next disabled">
                                    <a href="http://127.0.0.1:8088/admin/user/list?page=${currentPage+1}">
                                        <i class="icon-angle-right"></i>
                                    </a>
                                </li>
                            <#else>
                                <li class="next">
                                    <a href="http://127.0.0.1:8088/admin/user/list?page=${currentPage+1}">
                                        <i class="icon-angle-right"></i>
                                    </a>
                                </li>
                            </#if>

                            <li class="next">
                                <a href="http://127.0.0.1:8088/admin/user/list?page=${maxPage}">
                                    <i class="icon-double-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

            </div><!-- /.page-content --> <!-- area 1.2.2.2 -->
        </div><!-- /.main-content --> <!-- area 1.2.2 -->
    <#include "assembly/settings.ftl">
    </div><!-- /.main-container-inner -->
    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container --> <!-- area 1.2 -->

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
<script src="/js/admin/warning.js"></script>
<script type="text/javascript">
    $(".disabled").click(function (event) {
        event.preventDefault();
    });

    function editPage(userId) {
        console.log(userId);
//        window.location.href = "http://127.0.0.1:8088/admin/user/edit?id=" + userId;
    }

    jQuery(function($) {
        $(".btn-danger").click(function(){
            var uid=$(this).attr("name");//点击获取当前button的id值
            warn('warn!','确认删除!','f',true,'确认',function(){
                $.ajax({
                    url:"http://127.0.0.1:8088/admin/user/delete",
                    type:'POST',
                    dataType:'json',
                    data:{
                        id:uid,
                    },
                    success: function(data){
                        location.reload();
                    }
                });
            });

        });
    })
</script>
</body><!-- area 1 -->
</html>