<%@ include file="./taglibs.jsp"%>

<form:form modelAttribute="mail" class="form-horizontal" method="post" action="${contextPath}/mail">
		<input type="hidden" name="id" id="id" value="${mail.id}"/>

    <label><spring:message code="form.mail.to"></spring:message></label> 
    <form:input type="text" path="toName" name="toName" id="toName" placeholder="Type something" value="${mail.toName}"/> 
    <span class="help-block">
     <form:errors path="toName" cssClass="label label-warning" />
    </span> 
    
    <label><spring:message code="form.mail.subject"></spring:message></label> 
    <form:input path="subject" type="text" name="subject" id="subject" placeholder="Type something" value="${mail.subject}"/> 
    <span class="help-block">
     <form:errors path="subject" cssClass="label label-warning" />
    </span> 
    
    <label><spring:message code="form.mail.body"></spring:message></label> 
    <form:textarea rows="6" cssClass="span6" path="body" name="body" id="body" placeholder="Type something" value="${mail.body}"/> 
    <span class="help-block">
     <form:errors path="body" cssClass="label label-warning" />
    </span> 
    
    
    
		<div class="form-actions">
		  <button type="submit" class="btn btn-large btn-primary">
        <spring:message code="form.general.submit.title"></spring:message>
      </button>
		</div>
</form:form>
