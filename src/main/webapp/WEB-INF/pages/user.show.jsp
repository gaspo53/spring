<%@ include file="./taglibs.jsp"%>

<cw:choose>

<cw:when test="${fn:length(persons) gt 0}">
	<table class="table">
		<thead>
			<tr>
				<th><spring:message code="form.user.name"></spring:message></th>
        <th><spring:message code="form.user.last_name"></spring:message></th>
        <th><spring:message code="form.user.city"></spring:message></th>
        <th><spring:message code="form.user.email"></spring:message></th>
	      <th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<cw:forEach items="${persons}" var="person">
				<tr>
					  <td>${person.name}</td>
			          <td>${person.last_name}</td>
			          <td>${person.city}</td>
			          <td>${person.email}</td>
					<td>
					  <a class="btn btn-small" href="${contextPath}/person/update/${person.id}">
                <spring:message code="form.general.edit.title"></spring:message>
            </a>
	          
	          <a class="btn btn-small btn-danger" href="${contextPath}/person/delete/${person.id}">
                <spring:message code="form.general.delete.title"></spring:message>
            </a>
				  </td>
				</tr>
			</cw:forEach>
		</tbody>
	</table>
</cw:when>
<cw:otherwise>
  <div class="alert"><spring:message code="alert.no_users" />.</div>
</cw:otherwise>	
</cw:choose>

<a href="${contextPath}/person/new">
		<cw:set var="add_action_title"> 
		    <tiles:insertAttribute name="add_action_title" ignore="true"/> 
		</cw:set>
		<spring:message code="${add_action_title}"></spring:message>
</a>
