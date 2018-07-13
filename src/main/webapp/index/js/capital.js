$.ajax({
        type: 'POST',
        url: '../task/getScoreDetails.do',
        dataType: 'json',
        async: false,
        success: function (data) { 
        	console.log(data.result);
        	if(data.code=="0"){
        		for (var i = 0; i < data.result.length; i++) {
        			var sta ="";
        			var scoreC ="";
        			if(data.result[i].changeStatus==0){
        				sta="(待审核)";	
        				scoreC = transScoreChange(data.result[i].scoreChange);
        			}else if(data.result[i].changeStatus==2){
        				sta="(审核失败)";	
        				scoreC="赏金已撤回";
        			}else{
        				scoreC=transScoreChange(data.result[i].scoreChange);
        			}
        			$("#xi_m").append(
                			'<div class="xi_one">'+
                	            '<div class="container">'+
                	        		'<div class="xi_left">'+
                	                	'<p style="display: inline;">'+transScoreStatus(data.result[i].changeType)+'</p><p style="display: inline;color:#fe6e12;">'+sta+'</p>'+
                	                '</div>'+
                	                '<div class="xi_right">'+
                	                	'<p style="color:#333;">'+scoreC+'</p>'+
                	                    '<span>'+getDateTimeStr(data.result[i].changeTime)+'</span>'+
                	                '</div>'+
                	        	'</div>'+
                	        '</div>'
                		);
				}
        	}
        }
})