		
		 function search(){   
			$("#div2").hide(); 
			$("#div3").hide(); 
			$("#div4").hide(); 
		    $("#div1").show();  
	        var htmlobj = $.ajax({
		        type:"post",
	            url:"../dataset/tree.action",
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {
	                $("#dataset_tree").html(htmlobj.responseText);
	            }
	        });
	     }

		 function showFL(id,name,description){
			$("#dataset_id").val(id);
			var jsonData = {dataSet_ID:id,name:name,description:description};
	        var htmlobj = $.ajax({
	        	type:"post",
	            url:"../dataset/showFL.action",
	            data:jsonData,
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {
	                $("#filed_local").html(htmlobj.responseText);
	            }
	        });
		 }

		 function add(){
			 $("#div1").hide();			
	 		 $("#div2").show();
	 		 var htmlobj = $.ajax({
		        	type:"post",
		            url:"../dataset/showDatasetType.action",
		            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		            processData:true,
		            cache:false,
		            async:true,
		            success:function () {
		                $("#dataset_edit").html(htmlobj.responseText);
		            }
		        });
	     }
		 
         function edit(){
        	$("#div1").hide(); 
 			$("#div2").show();
			var dataset_id = $("#dataset_id").val();
			if("" == dataset_id){
				alert("请选择数据集！");
				$("#div2").hide(); 
				$("#div1").show();
				return;
			}else{
				var jsonData = {dataSet_ID:dataset_id};
		        var htmlobj = $.ajax({
		        	type:"post",
		            url:"../dataset/showDataset.action",
		            data:jsonData,
		            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		            processData:true,
		            cache:false,
		            async:true,
		            success:function () {
		                $("#dataset_edit").html(htmlobj.responseText);
		            }
		        });
			}			
         }

         function submit(id){
 	    	var dataset_ID = id;
 	        var	dataset_Name = $("#dataset_Name").val();
 	       if("" == dataset_Name){
	        	showTips("数据集名称不能为空！",250,1);
	        	return;
	        }	
 	        var	dataset_Description = $("#dataset_Description").val();
 	        var	dataset_Type = $("#dataset_Type").val();
 	        var jsonData = {dataset_ID:dataset_ID,dataset_Name:dataset_Name,dataset_Description:dataset_Description,dataset_Type:dataset_Type};
 	        var htmlobj = $.ajax({
 		        type:"post",
 	            url:"../dataset/datasetSubmit.action",
 	            data:jsonData,
 	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
 	            processData:true,
 	            cache:false,
 	            async:true,
 	            success:function () {
 	        	if("0" != dataset_ID){
 					if(1 == htmlobj.responseText){	
 	            		$("#filed_local").text("");
 						search();
 						showTips("提交成功！",250,1);				
 					}else if(-2 == htmlobj.responseText){	
						showTips("数据集已存在！",250,1);												
					}else{
 						showTips("提交失败！",250,1);												
 				    }
 	            }else{
 	            	if(1 == htmlobj.responseText){	
 	            		$("#filed_local").text("");
 	            		search();
 	            		showTips("添加成功！",250,1);	            	
 					}else if(-2 == htmlobj.responseText){	
						showTips("数据集已存在！",250,1);												
					}else{
 						showTips("添加失败！",250,1);											
 				    }
 		        }
 	            }
 	        });		    	
 	    }
	     
		function del(){
			var dataset_id = $("#dataset_id").val();
			if("" == dataset_id){
				alert("请选择数据集！");				
				return;
			}else{
				if(confirm("确认删除吗")){	
					var jsonData = {dataset_ID:dataset_id};
			        var htmlobj = $.ajax({
			        	type:"post",
			            url:"../dataset/datasetdelete.action",
			            data:jsonData,
			            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			            processData:true,
			            cache:false,
			            async:true,
			            success:function () {	
								if(!(0 == htmlobj.responseText)){
									$("#dataset_id").val("");
									$("#filed_local").text("");
									search();																						
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
			
		}	

		function editDatasetFiled(){
			$("#div1").hide(); 
	 		$("#div3").show();
	 		var dataset_id = $("#dataset_id").val();
	 		var fieldnameIndex = $("#fieldDescriptionIndex").val();
	 		if(undefined == fieldnameIndex){
	 			fieldnameIndex = "";
		 	}	 		
			if("" == dataset_id){
				alert("请选择数据集！");
				$("#div3").hide(); 
				$("#div1").show();
				return;
			}else{
				var jsonData = {dataSet_ID:dataset_id,pageNumber:1,fieldnameIndex:fieldnameIndex};
		        var htmlobj = $.ajax({
		        	type:"post",
		            url:"../dataset/showDatasetFiled.action",
		            data:jsonData,
		            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		            processData:true,
		            cache:false,
		            async:true,
		            success:function () {
		                $("#datasetField_edit").html(htmlobj.responseText);
		            }
		        });
			}			
		}

		function searchField(){
			var dataset_id = $("#dataset_id").val();
			var fieldNameIndex = $("#fieldNameIndex").val();
			var fieldDescriptionIndex = $("#fieldDescriptionIndex").val();
	        var jsonData = {pageNumber:1,fieldNameIndex:fieldNameIndex,fieldDescriptionIndex:fieldDescriptionIndex,dataSet_ID:dataset_id};
	        var htmlobj = $.ajax({
		        type:"post",
	            url:"../dataset/fieldShow.action",
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
			var dataset_id = $("#dataset_id").val();
			var fieldNameIndex = $("#fieldNameIndex").val();
		    var fieldDescriptionIndex = $("#fieldDescriptionIndex").val();
		    var jsonData = {pageNumber:num,fieldNameIndex:fieldNameIndex,fieldDescriptionIndex:fieldDescriptionIndex,dataSet_ID:dataset_id};
	        var htmlobj = $.ajax({
	        	type:"post",
	            url:"../dataset/fieldShow.action",
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

		    function addField(){
		    	$("#div3").hide(); 
		 		$("#div4").show(); 
		        var htmlobj = $.ajax({
			        type:"post",
		            url:"../dataset/fieldadd.action",
		            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		            processData:true,
		            cache:false,
		            async:true,
		            success:function () {
		                $("#localFiled_edit").html(htmlobj.responseText);
		            }
		        });		    	
		    }

		    function editField(fields_Local_ID){	  
		    	$("#div3").hide(); 
		 		$("#div4").show(); 
			    var fields_Local_ID = fields_Local_ID;
			    var jsonData = {fields_Local_ID:fields_Local_ID};
		        var htmlobj = $.ajax({
			        type:"post",
		            url:"../dataset/fieldreset.action",
		            data:jsonData,
		            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		            processData:true,
		            cache:false,
		            async:true,
		            success:function () {
		                $("#localFiled_edit").html(htmlobj.responseText);
		            }
		        });	    	
			}

		    function screen(){
				var screenIndex = $("#screenIndex").val();
				alert("screenIndex="+screenIndex);
				var jsonData = {screenIndex:screenIndex};
		        var htmlobj = $.ajax({
			        type:"post",
		            url:"../dataset/fieldscreen.action",
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
		            url:"../dataset/fieldsubmit.action",
		            data:jsonData,
		            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		            processData:true,
		            cache:false,
		            async:true,
		            success:function () {
			        	if("0" != fields_Local_ID){
							if(1 == htmlobj.responseText){	
								showTips("提交成功！",250,1);	
								$("#div4").hide(); 
						 		$("#div3").show(); 	
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
			            			$("#div4").hide(); 
							 		$("#div3").show(); 		            	
				            		seekByPage(pageId);			
			            		}
			            		if('add2' == operate){
			            			addField();
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
		    
		    function datasetCancel(){
		    	search();
		    	//location.href="dataset_m.jsp";
			}
		    
		    function cancel(){
		    	$("#div4").hide(); 
		 		$("#div3").show(); 	
		    	editDatasetFiled();
			}
		    
			function delField(id){
				if(confirm("确认删除吗")){	
					var pageId =  $(".on").text();	
					var encodetable =  $("#encodetable").val();
				 	var jsonData = {fields_Local_ID:id};
			        var htmlobj = $.ajax({
			        	type:"post",
			            url:"../dataset/fielddelete.action",
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

		function addRef(){
			var x = document.getElementsByName("filed");
			var j = 0;			
			var arr = new Array();
			for(var i=0;i<x.length;i++){
				if(x[i].checked==true){
					arr[j] = x[i].value;
					++j;							
				}					
			}
			if(arr.length == 0){
				showTips("请选择字段！",250,1);
				return;
			}else{
				var dataset_id = $("#dataset_id").val();
			    var jsonData = {dataSet_ID:dataset_id,arr:arr};
		        var htmlobj = $.ajax({
		        	type:"post",
		            url:"../dataset/addRef.action",
		            data:jsonData,
		            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		            processData:true,
		            cache:false,
		            async:true,
		            success:function () {
		            	if(1 == htmlobj.responseText){	
		            		showTips("添加成功！",250,1);	
		            		editDatasetFiled();				 		
						}else{
							showTips("添加失败！",250,1);											
					    }
		            }
		        });
			}
			
	    }

	    function refresh(){
	    	$("#fieldDescriptionIndex").val("");
	    	editDatasetFiled();	
	    }
			
		function updateRef(refId,is_Req_ID){
			var is_Req = document.getElementById(is_Req_ID).value;	
		    var jsonData = {refId:refId,is_Req:is_Req};
	        var htmlobj = $.ajax({
		        type:"post",
	            url:"../dataset/updateRef.action",
	            data:jsonData,
	            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	            processData:true,
	            cache:false,
	            async:true,
	            success:function () {
					if(1 == htmlobj.responseText){	
						showTips("提交成功！",250,1);	
					}else{
						showTips("提交失败！",250,1);												
				    }
	            }
	        });	
	        	
		}
		
		function delRef(refId,trId){
			if(confirm("确认删除吗")){
				var jsonData = {refId:refId};
		        var htmlobj = $.ajax({
			        type:"post",
		            url:"../dataset/delRef.action",
		            data:jsonData,
		            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		            processData:true,
		            cache:false,
		            async:true,
		            success:function () {
		        		if(1 == htmlobj.responseText){
							showTips("删除成功！",250,1);
							editDatasetFiled();	
							//var row=document.getElementById(trId).rowIndex;  
							//删除行所在表格中的位置
							//document.getElementById("filedRef").deleteRow(row); 
						}else{
							showTips("删除失败！",250,1);												
					    }
		            }
		        });		  
			}else{
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

		function check(){
			var x = document.getElementsByName("filed");
			for(var i=0;i<x.length;i++){
				if(document.getElementById("all").checked==true){
					x[i].checked=true;
				}
				if(document.getElementById("all").checked==false){
					x[i].checked=false;
				}
			}
		}
		
		function check2(){
			var x = document.getElementsByName("filed");
			var flag=true;
			for(var i=0;i<x.length;i++){
				if(x[i].checked!=true){
					flag=false;
					break;
				}					
			}
			if(flag){
				document.getElementById("all").checked=true	;
			}else{
				document.getElementById("all").checked=false;
			}
			
		}
		
		window.onload = search;	
