layui.config({
	base : "js/"
}).use(['form','layer'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		$ = layui.jquery;
	//video背景
	$(window).resize(function(){
		if($(".video-player").width() > $(window).width()){
			$(".video-player").css({"height":$(window).height(),"width":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}else{
			$(".video-player").css({"width":$(window).width(),"height":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}
	}).resize();
	
	//登录按钮事件
	form.on("submit(login)",function(data){
		console.log(data);
		$.ajax({
            type: 'POST',
            url: "../adminUser/login.do",
            dataType: 'json',
            data: data.field,//往后台发送的是data.field，即一个{name：value}的数据结构
            async: true,
            success: function (res) {
            	console.log(res)
            	if(res.result==true){
            		layer.msg('登录成功',{icon: 1},function(){
            			sessionStorage.clear();
            			window.location.href = "index.html";
	                });
            	}else{
            		layer.msg('用户名或密码错误！', {icon: 5});
            	}
            }
        })
//		window.location.href = "../../index.html";
		return false;
	})
})
