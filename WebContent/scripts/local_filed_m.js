		 function search(){	
			$("#form_div2").hide(); 
			$("#form_div1").show(); 	
			var fieldNameIndex = $("#fieldNameIndex").val();
	        var fieldDescriptionIndex = $("#fieldDescriptionIndex").val();
	        var jsonData = {pageNumber:1,fieldNameIndex:fieldNameIndex,fieldDescriptionIndex:fieldDescriptionIndex};
	        var htmlobj = $.ajax({
		        type:"post",
	            url:"../localfield/fieldseek.action",
	            data:jsonData,
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {
	                $("#local_filed_list").html(htmlobj.responseText);
	            }
	        });
	     }

		 function seekByPage(num) {
			var fieldNameIndex = $("#fieldNameIndex").val();
		    var fieldDescriptionIndex = $("#fieldDescriptionIndex").val();
		    var jsonData = {pageNumber:num,fieldNameIndex:fieldNameIndex,fieldDescriptionIndex:fieldDescriptionIndex};
	        var htmlobj = $.ajax({
	        	type:"post",
	            url:"../localfield/fieldseek.action",
	            data:jsonData,
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {
	                $("#local_filed_list").html(htmlobj.responseText);
	            }
	        });
	    }

	    function add(){
	    	$("#form_div1").hide(); 
		    $("#form_div2").show(); 
	        var htmlobj = $.ajax({
		        type:"post",
	            url:"../localfield/fieldadd.action",
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {
	                $("#local_filed_editlist").html(htmlobj.responseText);
	            }
	        });		    	
	    }

	    function edit(fields_Local_ID){	  
		    $("#form_div1").hide(); 
		    $("#form_div2").show(); 
		    var fields_Local_ID = fields_Local_ID;
		    var jsonData = {fields_Local_ID:fields_Local_ID};
	        var htmlobj = $.ajax({
		        type:"post",
	            url:"../localfield/fieldreset.action",
	            data:jsonData,
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {
	                $("#local_filed_editlist").html(htmlobj.responseText);
	            }
	        });	    	
		}

	    function screen(){
			var screenIndex = $("#screenIndex").val();
			var jsonData = {screenIndex:screenIndex};
	        var htmlobj = $.ajax({
		        type:"post",
	            url:"../localfield/fieldscreen.action",
	            data:jsonData,
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {
	                $("#screendiv").html(htmlobj.responseText);
	            }
	        });	    	
		}

	    function submitField(id,operate){
	    	var fields_Local_ID = id;
	        var	field_Name = $("#field_Name").val();
	        if("" == field_Name){
				showTips("本地字段值不能为空！",250,1);
				return;
			}		
	        var	field_Description = $("#field_Description").val();
	        var	fields_Global_ID = $("#fields_Global_ID").val();
	        var	data_Type = $("#data_Type").val();
	        var	is_Tran = $("#is_Tran").val();
	        var	regex = $("#regex").val();
	    	var pageId =  $(".on").text();	
	    	if(fields_Global_ID == null){
	    		fields_Global_ID="";
		    }
	        var jsonData = {fields_Local_ID:fields_Local_ID,field_Name:field_Name,field_Description:field_Description,
	        		fields_Global_ID:fields_Global_ID,data_Type:data_Type,is_Tran:is_Tran,regex:regex};
	        var htmlobj = $.ajax({
		        type:"post",
	            url:"../localfield/fieldsubmit.action",
	            data:jsonData,
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {
	        	if("0" != fields_Local_ID){
					if(1 == htmlobj.responseText){	
						showTips("提交成功！",250,1);	
						$("#form_div2").hide(); 
						$("#form_div1").show(); 			
						seekByPage(pageId);		
					}else if(-2 == htmlobj.responseText){	
						showTips("本地字段已存在！",250,1);	
					}else{
						showTips("提交失败！",250,1);												
				    }
	            }else{	            	
	            	if(1 == htmlobj.responseText){	
	            		showTips("添加成功！",250,1);
	            		if('add1' == operate){
	            			$("#form_div2").hide(); 
							$("#form_div1").show(); 	            	
		            		seekByPage(pageId);	
	            		}
	            		if('add2' == operate){
	            			add();
	            		}	
					}else if(-2 == htmlobj.responseText){	
						showTips("本地字段已存在！",250,1);	
					}else{
						showTips("添加失败！",250,1);											
				    }
		        }
	            }
	        });		    	
	    }
	    
	    function cancel(){
	    	search();
	    	//location.href="local_filed_m.jsp";
		}
		 
	    
		function del(id){
			if(confirm("确认删除吗")){	
				var pageId =  $(".on").text();	
				var encodetable =  $("#encodetable").val();
			 	var jsonData = {fields_Local_ID:id};
		        var htmlobj = $.ajax({
		        	type:"post",
		            url:"../localfield/fielddelete.action",
		            data:jsonData,
		            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		            processData:true,
		            cache:false,
		            async:true,
		            success:function () {	
							if(1 == htmlobj.responseText){
								seekByPage(pageId);																							
								showTips("删除成功！",250,1);
							
							}else{
								showTips("删除失败！",250,1);
											
						    }
		            }
		        });				
			 } else{		   
			   return;
			}
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
		
		function clearShowTips(){
			//$('div.tipsClass').text("");
			$( 'div.tipsClass' ).fadeOut();
		}
		
		window.onload = search;	
	