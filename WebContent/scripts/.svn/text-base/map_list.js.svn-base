		 function search(){
			var encodetable =  $("#encodetable").val();
	        var encodenameIndex1 = $("#encodenameIndex1").val();
	        var encodenameIndex2= $("#encodenameIndex2").val();
	        var jsonData = {encodetable:encodetable, pageNumber:1,encodenameIndex1:encodenameIndex1,encodenameIndex2:encodenameIndex2};
	        var htmlobj = $.ajax({
		        type:"post",
	            url:"../encode/encodeseek.action",
	            data:jsonData,
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {
	                $("#map_list").html(htmlobj.responseText);
	            }
	        });
	     }
	     		
		 function savaOrUpdate(id,oldvalue,myIndex,code_mark,oprate){
			var pageId =  $(".on").text();
			var oldvalue = document.getElementById(oldvalue).value;	
			if("update" == oprate || "add1" == oprate){
				var code_Val_Local = document.getElementById(id).value;	
				if("null" == code_Val_Local){
					showTips("值不能为null！",250,1);
					return;
				}
				if("" == code_Val_Local){
					showTips("值不能为空！",250,1);
					return;
				}				
			}
			
			if("add2" == oprate){
				var code_Val_Local = prompt("请输入本地映射的值：","");
				if(null == code_Val_Local){
					return;
				}
				if("null" == code_Val_Local){
					showTips("值不能为null！",250,1);
					return;
				}
				if("" == code_Val_Local){
					showTips("值不能为空！",250,1);
					return;
				}
			}			
								
		    var encodetable =  $("#encodetable").val();			   
	        var jsonData = {myIndex:myIndex,oldvalue:oldvalue,code_mark:code_mark, code_Val_Local:code_Val_Local, encodetable:encodetable};
	        var htmlobj = $.ajax({
	        	type:"post",
	            url:"../encode/encodeset.action",
	            data:jsonData,
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {
	            	if("null" != myIndex){
						if(0 == htmlobj.responseText){	
							showTips("提交失败！",250,1);												
						}else if(-2 == htmlobj.responseText){	
							showTips("记录重复！",250,1);												
						}else if(-3 == htmlobj.responseText){	
							showTips("fields_local_id不存在！",250,1);												
						}else{
							seekByPage(pageId);
							showTips("提交成功！",250,1);				
					    }
		            }else{
		            	if(0 == htmlobj.responseText){	
							showTips("添加失败！",250,1);											
						}else if(-2 == htmlobj.responseText){	
							showTips("记录重复！",250,1);												
						}else if(-3 == htmlobj.responseText){	
							showTips("fields_local_id不存在！",250,1);												
						}else{
		            		seekByPage(pageId);
		            		showTips("添加成功！",250,1);	            	
					    }
			        }
		                  
	            }
	       });
		}
		 		
		function seekByPage(num) {
		        var encodetable =  $("#encodetable").val();
		        var encodenameIndex1 = $("#encodenameIndex1").val();
		        var encodenameIndex2= $("#encodenameIndex2").val();
		        var jsonData = {encodetable:encodetable, pageNumber:num,encodenameIndex1:encodenameIndex1,encodenameIndex2:encodenameIndex2};
		        var htmlobj = $.ajax({
		        	type:"post",
		            url:"../encode/encodeseek.action",
		            data:jsonData,
		            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		            processData:true,
		            cache:false,
		            async:true,
		            success:function () {
		                $("#map_list").html(htmlobj.responseText);
		            }
		        });
	    }
	    
		function del(oldvalue,code_mark){			
			if(confirm("确认删除吗")){	
				var pageId =  $(".on").text();			
				var encodetable =  $("#encodetable").val();
				var oldvalue = document.getElementById(oldvalue).value;				
			 	var jsonData = {oldvalue:oldvalue,code_mark:code_mark, encodetable:encodetable};
		        var htmlobj = $.ajax({
		        	type:"post",
		            url:"../encode/encodedel.action",
		            data:jsonData,
		            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		            processData:true,
		            cache:false,
		            async:true,
		            success:function () {	
							if(0 == htmlobj.responseText){							
								showTips("删除失败！",250,1);
							}else{
								seekByPage(pageId);																							
								showTips("删除成功！",250,1);
						    }
		            }
		        });				
			 } else{		   
			   return;
			}
		}	
		
		function copyF(code_Val_System,id){
			var a = $("#"+id).val();
			$("#"+id).val(code_Val_System);
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
		
		window.onload = search;		
		
