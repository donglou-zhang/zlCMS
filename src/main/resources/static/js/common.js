function matchActive(preferedKind,kind){
	var choice_kind = (preferedKind != '') ? preferedKind : kind;
	switch (choice_kind){
		case "index":
			$(".nav li").removeClass("active");
			$(".nav li:eq(0)").addClass("active");
			$(document).attr("title", "首页");
			break;
		case "coding":
			$(".nav li").removeClass("active");
			$(".nav li:eq(1)").addClass("active");
			$(document).attr("title", "编程");
			break;
		case "reading":
			$(".nav li").removeClass("active");
			$(".nav li:eq(2)").addClass("active");
			$(document).attr("title", "读书");
			break;
		case "essay":
			$(".nav li").removeClass("active");
			$(".nav li:eq(3)").addClass("active");
			$(document).attr("title", "随笔");
			break;
	}	
}

function showLoginPanel()
{
	$(".login_panel").css("display","block");
}

function cancelLoginPanel()
{
	$(".login_panel").css("display","none");
}

function loginAction(){
	var username = $("#username_input").val();
	if(username == ""){
		$("#username_input").focus();
		$("#showInfo").html("请输入用户名");
		return;
	}
	var password = $("#password_input").val();
	if(password == ""){
		$("#password_input").focus();
		$("#showInfo").html("请输入密码");
		return;
	}
	$("#showInfo").html("");
	$.ajax({
		url:"http://localhost:8080/Blog/user/loginSubmit",
		type:'POST',
		dataType:'json',
		data:{
			username:username,
			password:password
		},
		success:function(data){
			if(data.status == 1){
				$("#showInfo").html("");
				window.location.reload();
			}else{
				$("#showInfo").html("用户名或密码错误");
			}
		}
	});
	
}