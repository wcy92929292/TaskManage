var user = getUser();
$("#loginName").text(user.loginName);
$("#phone").text("手机号："+user.phone)

$.ajax({
        type: 'POST',
        url: '../task/getUserTaskStatus.do',
        dataType: 'json',
        data: {},//yi个id
        async: false,
        success: function (data) { 
        	if (data.code == "0") {
        		if(data.noCom!=0){
        			$("#noCom span").html('<i>'+data.noCom+'</i>');
        		}
        		if(data.noCheck!=0){
        			$("#noCheck span").html('<i>'+data.noCheck+'</i>');
        		}
        		if(data.com!=0){
        			$("#com span").html('<i>'+data.com+'</i>');
        		}
        		if(data.fail!=0){
        			$("#fail span").html('<i>'+data.fail+'</i>');
        		}
        	}
        }
})

$.ajax({
        type: 'POST',
        url: '../task/getUserScore.do',
        dataType: 'json',
        async: false,
        success: function (data) {
        	console.log(data)
        	if(data.code=="0"){
        		$("#moneySum").html("￥"+data.result);
        	}
        }
})

$("#moneySum").click(function(){
	location.href="capital.html";
})