<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>控制台</title>
		<meta name="keywords" content="Zhanglei_Blog Admin " />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="/css/admin/ace/font-awesome.min.css" rel="stylesheet">
		<!--[if IE 7]>
		  <link rel="stylesheet" href="/css/admin/ace/font-awesome-ie7.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="/css/admin/ace/ace.min.css" />
		<link rel="stylesheet" href="/css/admin/ace/ace-rtl.min.css" />
		<link rel="stylesheet" href="/css/admin/ace/ace-skins.min.css" />
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="/css/admin/ace/ace-ie.min.css" />
		<![endif]-->
        <script src="/js/admin/ace/ace-extra.min.js"></script>
		<!--[if lt IE 9]>
		<script src="/js/admin/ace/html5shiv.js"></script>
		<script src="/js/admin/ace/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
		<#include "assembly/navbar.ftl">
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<#--<a class="menu-toggler" id="menu-toggler" href="#">-->
					<#--<span class="menu-text"></span>-->
				<#--</a>-->

				<#include "assembly/sidebar.ftl">

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">首页</a>
							</li>
							<li class="active">控制台</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<div class="row">
									<div class="space-6"></div>

									<div class="col-sm-7 infobox-container">
										<div class="infobox infobox-green  ">
											<div class="infobox-icon">
												<i class="icon-comments"></i>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number">32</span>
												<div class="infobox-content">2个评论</div>
											</div>
											<div class="stat stat-success">8%</div>
										</div>

										<div class="infobox infobox-blue  ">
											<div class="infobox-icon">
												<i class="icon-twitter"></i>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number">11</span>
												<div class="infobox-content">新粉丝</div>
											</div>

											<div class="badge badge-success">
												+32%
												<i class="icon-arrow-up"></i>
											</div>
										</div>

										<div class="infobox infobox-pink  ">
											<div class="infobox-icon">
												<i class="icon-shopping-cart"></i>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number">8</span>
												<div class="infobox-content">新文章</div>
											</div>
										</div>

										<div class="infobox infobox-red  ">
											<div class="infobox-icon">
												<i class="icon-beaker"></i>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number">7</span>
												<div class="infobox-content">页面查看次数</div>
											</div>
										</div>
									</div>

									<div class="vspace-sm"></div>

									<div class="col-sm-5">
										待写入
									</div>
								</div><!-- /row -->

								<div class="hr hr32 hr-dotted"></div>

								<div class="row">
									<div class="col-sm-5">
										<div class="widget-box transparent">
											<div class="widget-header widget-header-flat">
												<h4 class="lighter">
													<i class="icon-star orange"></i>
													热门域名
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
																<th>
																	<i class="icon-caret-right blue"></i>
																	名称
																</th>

																<th>
																	<i class="icon-caret-right blue"></i>
																	价格
																</th>

																<th class="hidden-480">
																	<i class="icon-caret-right blue"></i>
																	状态
																</th>
															</tr>
														</thead>

														<tbody>
															<tr>
																<td>internet.com</td>

																<td>
																	<small>
																		<s class="red">$29.99</s>
																	</small>
																	<b class="green">$19.99</b>
																</td>

																<td class="hidden-480">
																	<span class="label label-info arrowed-right arrowed-in">销售中</span>
																</td>
															</tr>

															<tr>
																<td>domain.com</td>

																<td>
																	<small>
																		<s class="red"></s>
																	</small>
																	<b class="green">$12.00</b>
																</td>

																<td class="hidden-480">
																	<span class="label label-warning arrowed arrowed-right">售完</span>
																</td>
															</tr>
														</tbody>
													</table>
												</div><!-- /widget-main -->
											</div><!-- /widget-body -->
										</div><!-- /widget-box -->
									</div>

									<div class="col-sm-7">
                                        <div class="widget-box transparent" id="recent-box">
                                            <div class="widget-header">
                                                <h4 class="lighter smaller">
                                                    <i class="icon-rss orange"></i>
                                                    最近
                                                </h4>

                                                <div class="widget-toolbar no-border">
                                                    <ul class="nav nav-tabs" id="recent-tab">
                                                        <li class="active">
                                                            <a data-toggle="tab" href="#member-tab">会员</a>
                                                        </li>

                                                        <li>
                                                            <a data-toggle="tab" href="#comment-tab">评论</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>

                                            <div class="widget-body">
                                                <div class="widget-main padding-4">
                                                    <div class="tab-content padding-8 overflow-visible">
                                                        <div id="member-tab" class="tab-pane active">
                                                            <div class="clearfix">
                                                                <div class="itemdiv memberdiv">
                                                                    <div class="user">
                                                                        <img alt="Bob Doe's avatar" src="/images/admin/user.jpg" />
                                                                    </div>

                                                                    <div class="body">
                                                                        <div class="name">
                                                                            <a href="#">Bob Doe</a>
                                                                        </div>

                                                                        <div class="time">
                                                                            <i class="icon-time"></i>
                                                                            <span class="green">20 min</span>
                                                                        </div>

                                                                        <div>
                                                                            <span class="label label-warning label-sm">pending</span>

                                                                            <div class="inline position-relative">
                                                                                <button class="btn btn-minier bigger btn-yellow btn-no-border dropdown-toggle" data-toggle="dropdown">
                                                                                    <i class="icon-angle-down icon-only bigger-120"></i>
                                                                                </button>

                                                                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
                                                                                    <li>
                                                                                        <a href="#" class="tooltip-success" data-rel="tooltip" title="Approve">
																							<span class="green">
																								<i class="icon-ok bigger-110"></i>
																							</span>
                                                                                        </a>
                                                                                    </li>

                                                                                    <li>
                                                                                        <a href="#" class="tooltip-warning" data-rel="tooltip" title="Reject">
																							<span class="orange">
																								<i class="icon-remove bigger-110"></i>
																							</span>
                                                                                        </a>
                                                                                    </li>

                                                                                    <li>
                                                                                        <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																							<span class="red">
																								<i class="icon-trash bigger-110"></i>
																							</span>
                                                                                        </a>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                            </div>

                                                            <div class="center">
                                                                <i class="icon-group icon-2x green"></i>

                                                                &nbsp;
                                                                <a href="#">
                                                                    查看所有会员 &nbsp;
                                                                    <i class="icon-arrow-right"></i>
                                                                </a>
                                                            </div>

                                                            <div class="hr hr-double hr8"></div>
                                                        </div><!-- member-tab -->

                                                        <div id="comment-tab" class="tab-pane">
                                                            <div class="comments">
                                                                <div class="itemdiv commentdiv">
                                                                    <div class="user">
                                                                        <img alt="Bob Doe's Avatar" src="/images/admin/avatar.png" />
                                                                    </div>

                                                                    <div class="body">
                                                                        <div class="name">
                                                                            <a href="#">Bob Doe</a>
                                                                        </div>

                                                                        <div class="time">
                                                                            <i class="icon-time"></i>
                                                                            <span class="green">6 min</span>
                                                                        </div>

                                                                        <div class="text">
                                                                            <i class="icon-quote-left"></i>
                                                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque commodo massa sed ipsum porttitor facilisis &hellip;
                                                                        </div>
                                                                    </div>

                                                                    <div class="tools">
                                                                        <div class="inline position-relative">
                                                                            <button class="btn btn-minier bigger btn-yellow dropdown-toggle" data-toggle="dropdown">
                                                                                <i class="icon-angle-down icon-only bigger-120"></i>
                                                                            </button>

                                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
                                                                                <li>
                                                                                    <a href="#" class="tooltip-success" data-rel="tooltip" title="Approve">
																						<span class="green">
																							<i class="icon-ok bigger-110"></i>
																						</span>
                                                                                    </a>
                                                                                </li>

                                                                                <li>
                                                                                    <a href="#" class="tooltip-warning" data-rel="tooltip" title="Reject">
																						<span class="orange">
																							<i class="icon-remove bigger-110"></i>
																						</span>
                                                                                    </a>
                                                                                </li>

                                                                                <li>
                                                                                    <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																						<span class="red">
																							<i class="icon-trash bigger-110"></i>
																						</span>
                                                                                    </a>
                                                                                </li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="hr hr8"></div>

                                                            <div class="center">
                                                                <i class="icon-comments-alt icon-2x green"></i>

                                                                &nbsp;
                                                                <a href="#">
                                                                    See all comments &nbsp;
                                                                    <i class="icon-arrow-right"></i>
                                                                </a>
                                                            </div>

                                                            <div class="hr hr-double hr8"></div>
                                                        </div>
                                                    </div>
                                                </div><!-- /widget-main -->
                                            </div><!-- /widget-body -->
                                        </div><!-- /widget-box -->
									</div>
								</div>

								<div class="hr hr32 hr-dotted"></div>

								<div class="row">
									<div class="col-sm-6">

									</div><!-- /span -->
								</div><!-- /row -->

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

				<#include "assembly/settings.ftl">
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='/js/admin/ace/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='/js/admin/ace/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="/js/admin/ace/typeahead-bs2.min.js"></script>
		<script src="/js/admin/ace/jquery-ui-1.10.3.custom.min.js"></script>
        <script src="/js/admin/ace/flot/jquery.flot.min.js"></script>
        <script src="/js/admin/ace/flot/jquery.flot.pie.min.js"></script>
		<script src="/js/admin/ace/flot/jquery.flot.resize.min.js"></script>
		<script src="/js/admin/ace/ace-elements.min.js"></script>
		<script src="/js/admin/ace/ace.min.js"></script>
		<script type="text/javascript">
			jQuery(function($) {

			})
		</script>

</body>
</html>

