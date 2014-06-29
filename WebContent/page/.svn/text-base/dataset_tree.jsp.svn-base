<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<script type="text/javascript">	
		$(function(){
			$(".st_tree").SimpleTree({
				click:function(a){
					if(!$(a).attr("hasChild"))
						alert($(a).attr("ref"));
				}
			});
		});
		</script>
  		<div   class="st_tree" id="dataset_tree" style="overflow:auto;height:380px">
  		  <ul>  
  		  	  <c:forEach items="${datasetMap}" var="map">
  		  	  	<c:if test="${map.key =='EHRlist'}">
  		  	  		 <li><a href="#">EHR</a></li>
  		  	  		 <ul show="false">
  		  	  		 <c:forEach items="${map.value}" var="EHRlist">
							<li><a a href="javascript:void(0);" onclick="javascript:showFL(${EHRlist.dataset_ID},'${EHRlist.dataset_Name}','${EHRlist.dataset_Description}')">${EHRlist.dataset_Name}【${EHRlist.dataset_Description}】</a></li>
  		  	  		 </c:forEach>	
					</ul>
  		  	  	</c:if>
  		  	  	<c:if test="${map.key =='EMRlist'}">
  		  	  		 <li><a href="#">EMR</a></li>
  		  	  		 <ul show="false">
  		  	  		 <c:forEach items="${map.value}" var="EMRlist">
							<li><a a href="javascript:void(0);" onclick="javascript:showFL(${EMRlist.dataset_ID},'${EMRlist.dataset_Name}','${EMRlist.dataset_Description}')">${EMRlist.dataset_Name}【${EMRlist.dataset_Description}】</a></li>
  		  	  		 </c:forEach>	
					</ul>
  		  	  	</c:if><c:if test="${map.key =='HIlist'}">
  		  	  		 <li><a href="#">HI</a></li>
  		  	  		 <ul show="false">
  		  	  		 <c:forEach items="${map.value}" var="HIlist">
							<li><a a href="javascript:void(0);" onclick="javascript:showFL(${HIlist.dataset_ID},'${HIlist.dataset_Name}','${HIlist.dataset_Description}')">${HIlist.dataset_Name}【${HIlist.dataset_Description}】</a></li>
  		  	  		 </c:forEach>	
					</ul>
  		  	  	</c:if>
  		  	  </c:forEach>  			 
		  </ul>			
  		</div>
