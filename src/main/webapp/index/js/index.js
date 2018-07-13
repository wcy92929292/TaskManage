// JavaScript Document



$(".scroll a").click(function(){
	$(this).addClass('currer').siblings().removeClass('currer');
	})


$(window.document).scroll(function () {
	var t_shu=$(".banner").height();
	var g_shu=$(".hot").height();
	if($(window).scrollTop()>t_shu){
			$(".top").css({background:"#fff",borderBottom:"1px solid #ccc"})
		}else{
			$(".top").css({background:"transparent",borderBottom:"none"})
			};
	if($(window).scrollTop()>t_shu+g_shu){
			$(".nav_s").addClass('pos')
		}else{
			$(".nav_s").removeClass('pos')
			};
})


$(".dao").click(function(){
	$('.dao i,.dao span').css('color','#7b7b7b');
	$(this).find('i,span').css('color','#246fc0');
	})

$(".left_c li").click(function(){
	$('.left_c li a').css('color','#484848');
	$(this).css({background:"#fff"}).siblings().css({background:"transparent"});
	$(this).find('a').css('color','#246fc0');
	})


//商家
$(".titll .col-xs-4,.titll .col-xs-2").click(function(){
	$('.titll .col-xs-2').css('color','#666');
	$(this).css('color','#246fc0').siblings().css('color','#666');
	})

$(".sp_s").click(function(){
	$('.lie').css('display','block').siblings().css('display','none');
	$('.footer').css('display','block');
	})

$(".sp_p").click(function(){
	$('.ping').css('display','block').siblings().css('display','none');
	$('.footer').css('display','none');
	})

$(".sp_j").click(function(){
	$('.shop').css('display','block').siblings().css('display','none');
	$('.footer').css('display','none');
	})


$(".shou").click(function(){
if($(".icon-shoucang1").css("display")=="none"){
$(".icon-shoucang1").show();
$(".icon-shoucang").hide();
}else{
$(".icon-shoucang1").hide();
$(".icon-shoucang").show();
}
});


$(document).ready(function(){
//获得文本框对象
   var t = $("#text_box");
//初始化数量为1,并失效减
$('#min').attr('disabled',true);
    //数量增加操作
    $("#add").click(function(){    
        t.val(parseInt(t.val())+1)
        if (parseInt(t.val())!=1){
            $('#min').attr('disabled',false);
        }
      
    }) 
    //数量减少操作
    $("#min").click(function(){
        t.val(parseInt(t.val())-1);
        if (parseInt(t.val())==1){
            $('#min').attr('disabled',true);
        }
      
    })
   
});


$('.icon-iconfontgouwuche').click(function(){
	$('.window').css('display','block');
	$('.gou').css('display','block');
	})

$('.window').click(function(){
	$('.window').css('display','none');
	$('.gou').css('display','none');
	})


//支付

$(".zhong").click(function(){
if($(".icon-xuanzhong").css("display")=="none"){
$(".icon-xuanzhong").show();
$(".icon-weixuanzhong").hide();
}else{
$(".icon-xuanzhong").hide();
$(".icon-weixuanzhong").show();
}
});


//商家订单

$('.fa').click(function(){
	$('.window').css('display','block');
	$('.tis').css('display','block');
	})

$('.window').click(function(){
	$('.window').css('display','none');
	$('.tis').css('display','none');
	})


function getUser(){
	var result;
	$.ajax({
        type: 'POST',
        url: '../user/getUserSession.do',
        dataType: 'json',
        data: {},//yi个id
        async: false,
        success: function (data) { 
        	if (data.code == "0") {
        		result = data.data;
        	}
        }
	})
	return result;
}
function GetQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}
//var time1 = new Date().format("yyyy-MM-dd hh:mm:ss");
Date.prototype.format = function(fmt) { 
    var o = { 
       "M+" : this.getMonth()+1,                 //月份 
       "d+" : this.getDate(),                    //日 
       "h+" : this.getHours(),                   //小时 
       "m+" : this.getMinutes(),                 //分 
       "s+" : this.getSeconds(),                 //秒 
       "q+" : Math.floor((this.getMonth()+3)/3), //季度 
       "S"  : this.getMilliseconds()             //毫秒 
   }; 
   if(/(y+)/.test(fmt)) {
           fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
   }
    for(var k in o) {
       if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
   return fmt; 
}
//
//毫秒数转日期时间
function getDateTimeStr(date){
    var temp = new Date(date);
    var y = temp.getFullYear();
    var m = (temp.getMonth()+1)+"";
    m = m.length >1? m:"0"+m;
    var d = temp.getDate()+"";
    d = d.length >1? d:"0"+d;
    var hh = temp.getHours()+"";
    hh = hh.length >1? hh:"0"+hh;
    var mm = temp.getMinutes()+"";
    mm = mm.length >1? mm:"0"+mm;
    var ss = temp.getSeconds()+"";
    ss = ss.length >1? ss:"0"+ss;
    return y+"-"+m+"-"+d+" "+hh+":"+mm+":"+ss;
}

//毫秒数转日期时间
function getDateTimeStrDate(date){
    var temp = new Date(date);
    var y = temp.getFullYear();
    var m = (temp.getMonth()+1)+"";
    m = m.length >1? m:"0"+m;
    var d = temp.getDate()+"";
    d = d.length >1? d:"0"+d;
    var hh = temp.getHours()+"";
    hh = hh.length >1? hh:"0"+hh;
    var mm = temp.getMinutes()+"";
    mm = mm.length >1? mm:"0"+mm;
    var ss = temp.getSeconds()+"";
    ss = ss.length >1? ss:"0"+ss;
    return y+"-"+m+"-"+d;
}
/**
 * 时间段翻译
 * @param a
 * @returns {String}
 */
function tranStatus(a){
	var status="";
	switch (a) {
	case 0:
		status="待完成";
		break;
	case 1:
		status="待审核";
		break;
	case 2:
		status="已完成";
		break;
	case 3:
		status="审核失败";
		break;
	case 4:
		status="过期失败";
		break;
	default:
		break;
	}
	return status;
	
}
/**
 * 转
 * @param a
 * @returns {String}
 */
function tranPeriod(a){
	var period="";
	switch (a) {
	case 0:
		period="30分钟";
		break;
	case 1:
		period="1小时";
		break;
	case 2:
		period="2小时";
		break;
	default:
		break;
	}
	return period;
	
}
function transScoreStatus(a){
	var status="";
	switch (a) {
	case 0:
		status="完成任务";
		break;
	case 1:
		status="提现";
		break;
	default:
		break;
	}
	return status;
}

function transScoreChange(a){
	var status="";
	if(a>0){
		status = "+"+a;
	}else{
		status = ""+a
	}
	return status;
	
}