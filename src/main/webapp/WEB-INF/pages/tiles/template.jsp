<%@ include file="../taglibs.jsp" %>

<!DOCTYPE html> 

<cw:set var="staticPath"  value="" scope="application" /><%-- Static resources Path --%>
<cw:set var="contextPath"  value="${pageContext.request.contextPath}" scope="application" /><%-- Static resources Path --%>

<!--[if IE 8]>         <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->

<html>
  <head>
    <tiles:insertAttribute name="meta"/>
    <tiles:insertAttribute name="head"/>
  </head>
  <body>
     <tiles:insertAttribute name="navbar"/>
     <div class="container-fluid">
       <div class="row-fluid">
		     <tiles:insertAttribute name="sidebar"/>
		     <div class="span9">
		        <h1>
		          <cw:set var="section_title"> 
		              <tiles:insertAttribute name="section_title" ignore="true"/> 
              </cw:set>
		          <spring:message code="${section_title}"></spring:message>
	          </h1>
	          <fieldset>
	             <cw:set var="subsection_legend"> 
	                 <tiles:insertAttribute name="subsection_legend" ignore="true"/> 
	             </cw:set>
	             <legend><spring:message code="${subsection_legend}"></spring:message></legend>
	             
	             <tiles:insertAttribute name="flash_messages" />
		           
		           <tiles:insertAttribute name="body" />
		        </fieldset>
		     </div>
      </div><!--/row-->
      <tiles:insertAttribute name="footer"/>
    </div><!--/.fluid-container-->
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="${contextPath}/${staticPath}/js/jquery.min.js"></script>
    <script src="${contextPath}/${staticPath}/js/bootstrap.min.js"></script>
    
  </body>
</html>
