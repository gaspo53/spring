<%@ include file="./taglibs.jsp"%>

<cw:choose>

<cw:when test="${fn:length(mails) gt 0}">
	<table class="table">
		<thead>
			<tr>
        <th><spring:message code="form.mail.to"></spring:message></th>
        <th><spring:message code="form.mail.subject"></spring:message></th>
        <th><spring:message code="form.mail.date"></spring:message></th>
	      <th><spring:message code="form.general.actions.title"></spring:message></th>
			</tr>
		</thead>
		<tbody>
			<cw:forEach items="${mails}" var="mail">
				<tr>
          <td>${mail.toName}</td>
          <td>${mail.subject}</td>
          <td>${mail.createdAt}</td>
					<td>
					  <a class="btn btn-small" href="${contextPath}/mail/update/${mail.id}">
                <spring:message code="form.general.edit.title"></spring:message>
            </a>
	          
	          <a class="btn btn-small btn-danger" href="${contextPath}/mail/delete/${mail.id}">
                <spring:message code="form.general.delete.title"></spring:message>
            </a>
				  </td>
				</tr>
			</cw:forEach>
		</tbody>
	</table>
</cw:when>
<cw:otherwise>
  <div class="alert"><spring:message code="alert.no_mails" />.</div>
</cw:otherwise>	
</cw:choose>

<a href="${contextPath}/mail/new">
		<cw:set var="add_action_title"> 
		    <tiles:insertAttribute name="add_action_title" ignore="true"/> 
		</cw:set>
		<spring:message code="${add_action_title}"></spring:message>
</a>
