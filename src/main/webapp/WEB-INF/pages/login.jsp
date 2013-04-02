<%@ include file="./taglibs.jsp" %>

<!DOCTYPE html> 
<cw:set var="section_title"> 
    <tiles:insertAttribute name="section_title" ignore="true"/> 
</cw:set>
<cw:set var="submit_button_label"> 
     <tiles:insertAttribute name="submit_button_label" ignore="true"/> 
</cw:set>

<cw:set var="staticPath"  value="" scope="application" /><%-- Static resources Path --%>
<cw:set var="contextPath"  value="${pageContext.request.contextPath}" scope="application" /><%-- Static resources Path --%>

<!--[if IE 8]>         <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->

<html>
  <head>
    <tiles:insertAttribute name="meta"/>
    <link href="${contextPath}/${staticPath}css/signin-fix.css" rel="stylesheet">
    <tiles:insertAttribute name="head"/>
  </head>
  <body>
		<div class="container">
	
				<cw:if test="${not empty error}">
					<div class="alert alert-error">
						<spring:message code="error.global.login_error"></spring:message>:
						${SPRING_SECURITY_LAST_EXCEPTION.message}
					</div>
				</cw:if>
		
				<form name='f' class="form-signin" action="<cw:url value='j_spring_security_check'/>" method="post">
					<h2 class="form-signin-heading">
					   <spring:message code="${section_title}"></spring:message>
          </h2>
					
					<input type="text" 
					       class="input-block-level" 
					       name='j_username'
						     placeholder="Username"
						     autofocus
		      > 
					
					<input type="password"
						     class="input-block-level" 
						     name='j_password' 
						     placeholder="Password"
		      >
		
					<button class="btn btn-large btn-primary" type="submit" name='submit'>
					   <spring:message code="${submit_button_label}"></spring:message>
					</button>
				</form>
			
			</div>
	
  </body>
</html>