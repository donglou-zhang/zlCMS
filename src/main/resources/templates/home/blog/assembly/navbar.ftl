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
            <ul class="nav navbar-nav" id="blog-nav">
                <#if kind=="index">
                    <li class="active">
                        <a href="/blog/index">首页</a>
                    </li>
                <#else>
                    <li>
                        <a href="/blog/index">首页</a>
                    </li>
                </#if>
                <#if kind=="coding">
                    <li class="active">
                        <a href="/blog/coding">编程</a>
                    </li>
                <#else>
                    <li>
                        <a href="/blog/coding">编程</a>
                    </li>
                </#if>
                <#if kind=="reading">
                    <li class="active">
                        <a href="/blog/reading">读书</a>
                    </li>
                <#else>
                    <li>
                        <a href="/blog/reading">读书</a>
                    </li>
                </#if>
                <#if kind=="recording">
                    <li class="active">
                        <a href="/blog/recording">随笔</a>
                    </li>
                <#else>
                    <li>
                        <a href="/blog/recording">随笔</a>
                    </li>
                </#if>
            </ul>
            <script type="text/javascript">
                var current_page = 0;

//                function addClass(obj, cls){
//                    var obj_class = obj.className,//获取 class 内容.
//                            blank = (obj_class != '') ? ' ' : '';//判断获取到的 class 是否为空, 如果不为空在前面加个'空格'.
//                    added = obj_class + blank + cls;//组合原来的 class 和需要添加的 class.
//                    obj.className = added;//替换原来的 class.
//                }
//
//                var index_pattern = new RegExp("(.*?)/index");
//                var coding_pattern = new RegExp("(.*?)/coding");
//                var reading_pattern = new RegExp("(.*?)/reading");
//                var recording_pattern = new RegExp("(.*?)/recording");
//                var current_kind;
//                var lis = document.getElementById("bs-navbar").getElementsByTagName("ul")[0].getElementsByTagName("li");
//                if(index_pattern.test(location.href)) {
//                    addClass(lis[0], "active");
//                    current_kind = "index";
//                }
//                else if(coding_pattern.test(location.href)) {
//                    addClass(lis[1], "active");
//                    current_kind = "coding";
//                }
//                else if(reading_pattern.test(location.href)) {
//                    addClass(lis[2], "active");
//                    current_kind = "reading";
//                }
//                else if(recording_pattern.test(location.href)) {
//                    addClass(lis[3], "active");
//                    current_kind = "recording";
//                }
            </script>
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