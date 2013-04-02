
<%@ include file="../taglibs.jsp"%>

<div class="span3">
	<div class="well sidebar-nav">
		<ul class="nav nav-list">
			<li class="nav-header"><spring:message
					code="layout.sidebar.section_1.title"></spring:message></li>
			<li class="" id="layout.sidebar.section_1.1"><a href="${contextPath}/mail"><spring:message
						code="layout.sidebar.section_1.1"></spring:message></a></li>
			<li id="layout.sidebar.section_1.2"><a href="${contextPath}/person/report/pdf"><spring:message
						code="layout.sidebar.section_1.2"></spring:message></a></li>
			<li id="layout.sidebar.section_1.3"><a href="${contextPath}/person/report/xls"><spring:message
						code="layout.sidebar.section_1.3"></spring:message></a></li>
			<li id="layout.sidebar.section_1.4"><a href="#"><spring:message
						code="layout.sidebar.section_1.4"></spring:message></a></li>
			<li class="nav-header"><spring:message
					code="layout.sidebar.section_2.title"></spring:message></li>
			<li id="layout.sidebar.section_2.1"><a href="#"><spring:message
						code="layout.sidebar.section_2.1"></spring:message></a></li>
			<li class="nav-header" ><spring:message
					code="layout.sidebar.section_3.title"></spring:message></li>
			<li><a href="#"><spring:message
						code="layout.sidebar.section_3.title"></spring:message></a></li>
		</ul>
	</div>
	<!--/.well -->
</div>
<!--/span-->

    <script>
       try{
	        var sidebar_item = document.getElementById('<tiles:insertAttribute name="sidebar_item_id" ignore="true"/>');
	        sidebar_item.className = sidebar_item.className + " active";
       }
       catch (error){
    	   
       }
    </script>