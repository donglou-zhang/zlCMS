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