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