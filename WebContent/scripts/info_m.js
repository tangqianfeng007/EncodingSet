	  
	function save(user){			
	        var	oldPW = $("#oldPW").val();
	        var	newPW = $("#newPW").val();
	        var	rnewPW = $("#rnewPW").val();
	        alert(user+"-"+oldPW+"-"+newPW+"-"+rnewPW);
	        if("" == oldPW){
				showTips("原密码不能为空！",250,1);
				return;
			}else if("" == newPW){
				showTips("新密码不能为空！",250,1);
				return;
			}else if("" == rnewPW){
				showTips("确认密码不能为空！",250,1);
				return;
			}else if(newPW != rnewPW){
				showTips("两次输入密码不一致！",250,1);
				return;
			}	      
	        var jsonData = {role:user,oldPW:oldPW,newPW:newPW};
	        var htmlobj = $.ajax({
		        type:"post",
	            url:"../info/editPW.action",
	            data:jsonData,
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {	        
					if(1 == htmlobj.responseText){	
						cancel();
						showTips("密码修改成功！",250,1);	
					}else if(-2 == htmlobj.responseText){	
						showTips("原密码错误！",250,1);	
					}else{
						showTips("密码修改失败！",250,1);												
				    }	           
	            }
	        });		    	
	    }
	    
	    function cancel(){	    
	    	location.href="info_m.jsp";
		} 
		
		function showTips( tips, height, time ){ 
			var windowWidth = document.documentElement.clientWidth; 
			var tipsDiv = '<div  id="message"  class="tipsClass">' + tips + '</div>'; 
			$( 'body' ).append( tipsDiv ); 
			$( 'div.tipsClass' ).css({ 
			'top' : height + 'px', 
			'left' : ( windowWidth / 2 ) - ( tips.length * 13 / 2 ) + 'px', 
			'position' : 'absolute', 
			'padding' : '3px 5px', 
			'background': '#00BFFF', 
			'font-size' : 28 + 'px', 
			'margin' : '0 auto', 
			'text-align': 'center', 
			'width' : 'auto', 
			'color' : '#fff', 
			'opacity' : '0.8' 
			}).show(); 
			setTimeout( function(){	var div = document.getElementById("message");document.body.removeChild(div);}, ( time * 1000 ) ); 
		} 				


	