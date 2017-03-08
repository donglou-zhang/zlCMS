<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="icon-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="icon-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="icon-group"></i>
            </button>

            <button class="btn btn-danger">
                <i class="icon-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- #sidebar-shortcuts -->

    <ul class="nav nav-list">
        <li class="active">
            <a href="/admin/index">
                <i class="icon-dashboard"></i>
                <span class="menu-text"> 控制台 </span>
            </a>
        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-user"></i>
                <span class="menu-text"> 用户 </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <li>
                    <a href="/admin/user/list">
                        <i class="icon-double-angle-right"></i>
                        用户列表
                    </a>
                </li>

                <li>
                    <a href="/admin/user/add">
                        <i class="icon-double-angle-right"></i>
                        添加用户
                    </a>
                </li>
            </ul>
        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-book"></i>
                <span class="menu-text"> 文章 </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <li>
                    <a href="/admin/article/list">
                        <i class="icon-double-angle-right"></i>
                        文章列表
                    </a>
                </li>

                <li>
                    <a href="/admin/article/edit">
                        <i class="icon-double-angle-right"></i>
                        添加文章
                    </a>
                </li>
            </ul>
        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-link"></i>
                <span class="menu-text"> 友链 </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <li>
                    <a href="/admin/f_link/list">
                        <i class="icon-double-angle-right"></i>
                        友链列表
                    </a>
                </li>

                <li>
                    <a href="/admin/f_link/add">
                        <i class="icon-double-angle-right"></i>
                        添加友链
                    </a>
                </li>
            </ul>
        </li>

        <li>
            <a href="typography.html">
                <i class="icon-text-width"></i>
                <span class="menu-text"> 评论管理 </span>
            </a>
        </li>

        <li>
            <a href="gallery.html">
                <i class="icon-picture"></i>
                <span class="menu-text"> 图片管理 </span>
            </a>
        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-tag"></i>
                <span class="menu-text"> 其他工具 </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <li>
                    <a href="profile.html">
                        <i class="icon-double-angle-right"></i>
                        云存储
                    </a>
                </li>

                <li>
                    <a href="inbox.html">
                        <i class="icon-double-angle-right"></i>
                        自动化工具
                    </a>
                </li>
            </ul>
        </li>
    </ul><!-- /.nav-list -->

    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
        $(".nav-list li").each(function () {
            $(this).removeClass("active");
        });
        var curr_menu = window.location.href.split("/")[4];
        switch (curr_menu) {
            case "index":
                $(".nav-list").children("li:eq(0)").addClass("active");
                break;
            case "user":
                $(".nav-list").children("li:eq(1)").addClass("active");
                break;
            case "article":
                $(".nav-list").children("li:eq(2)").addClass("active");
                break;
            case "comment":
                $(".nav-list").children("li:eq(3)").addClass("active");
                break;
            case "picture":
                $(".nav-list").children("li:eq(4)").addClass("active");
                break;
            case "tool":
                $(".nav-list").children("li:eq(5)").addClass("active");
                break;
        }
    </script>
</div>