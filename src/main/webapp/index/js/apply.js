//document.getElementById('file').onchange = function() {
//    var imgFile = this.files;
//    var fr = new FileReader();
//    fr.onload = function() {
//    	for (var int = 0; int < imgFile.length; int++) {
//    		document.getElementById('image').getElementsByTagName('img')[int].src = fr.result;
//		}
//    };
//    fr.readAsDataURL(imgFile);
//};
 //选择图片，马上预览  
    function xmTanUploadImg(obj) {

        var fl=obj.files.length;
        for(var i=0;i<fl;i++){
            var file=obj.files[i];
//            判断图片
            if(!/image\/\w+/.test(file.type)){
                alert('请上传图片!');
                return false;
            }
            var reader = new FileReader();
            //读取文件过程方法
            reader.onerror = function (e) {
                alert("读取异常....");
            }
            reader.onload = function (e) {
                var imgstr='<img class="lit" src="'+e.target.result+'"/>';
                var oimgbox=document.getElementById("image");
                var ndiv=document.createElement("div");//创建div节点

                //限制上传的图片数
                var a=$('#image>div').length;
                if(a<5){
                    ndiv.innerHTML=imgstr;
                    ndiv.className="lit";
                    oimgbox.appendChild(ndiv);
                }else{
                    alert('最多5张图片');
                }
            }
            reader.readAsDataURL(file);
        }

    }

$("#aid").val(GetQueryString("aid"));
//$("#submit").click(function(){
//	var formData = new FormData(); 
//	if($('#file')[0].files[0]==null){
//		alert("请先上传图片");
//		return false;
//	}
//	var arr=new Array();
//	for (var int = 0; int < $('#file')[0].files.length; int++) {
//		arr.push($('#file')[0].files[int]);
//	}
//	formData.append('file', arr);  //添加图片信息的参数
//	formData.append('aid', GetQueryString("aid"));  //添加图片信息的参数
//	$.ajax({
//	    url: '../upload/uploadHead.do',
//	    type: 'POST',
//	    cache: false, //上传文件不需要缓存
//	    data: formData,
//	    processData: false, // 告诉jQuery不要去处理发送的数据
//	    contentType: false, // 告诉jQuery不要去设置Content-Type请求头
//	    success: function (data) {
////	        var rs = eval("("+data+")");
//	        if(data.code=="0"){
//	            alert('上传成功 等待审核！');
//	            location.href='applySuccess.html';
//	        }else{
//	        	alert('上传失败 重新进入上传！');
//	        	location.href='applyFail.html'
//	        }
//	    },
//	    error: function (data) {
//	        tipTopShow("上传失败");
//	    }
//	})  
//})
