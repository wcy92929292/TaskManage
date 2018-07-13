$("#register").click(function(){
	$.ajax({
        type: 'POST',
        url: '../user/checkCode.do',
        dataType: 'json',
        data: {
        	"phone":$("input[name='phone']").val(),
        	"password":$("input[name='password']").val(),
        	"checkCode":$("input[name='checkcode']").val()
        	},//往后台发送的是data.field，即一个{name：value}的数据结构
        async: true,
        success: function (result) {
            if (result.code == 0) {
            	alert("成功");
            	location.href="login.html";
            } else {
            	alert("失败");
                /* layer.msg('获取失败！' + result.msg, {icon: 2, time: 1000}); */
            }
        },
        error: function (result, type) {
        	alert("失败");
            /* layer.msg('获取失败！', {icon: 2, time: 1000}); */
        }
    });
})