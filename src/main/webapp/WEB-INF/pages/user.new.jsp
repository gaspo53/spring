<%@ include file="./taglibs.jsp"%>

<form:form modelAttribute="person" class="form-horizontal" method="post" action="${contextPath}/person">
		<input type="hidden" name="id" id="id" value="${person.id}"/>

		<label><spring:message code="form.user.name"></spring:message></label> 
		<form:input path="name" type="text" name="name" id="name" placeholder="Type something" value="${person.name}"/> 
    <span class="help-block">
     <form:errors path="name" cssClass="label label-warning" />
    </span> 

    <label><spring:message code="form.user.last_name"></spring:message></label> 
    <form:input type="text" path="last_name" name="last_name" id="last_name" placeholder="Type something" value="${person.last_name}"/> 
    <span class="help-block">
     <form:errors path="last_name" cssClass="label label-warning" />
    </span> 
    
    <label><spring:message code="form.user.email"></spring:message></label> 
    <form:input path="email" type="email" name="email" id="email" placeholder="Type something" value="${person.email}"/> 
    <span class="help-block">
     <form:errors path="email" cssClass="label label-warning" />
    </span> 
    
		<label>City</label> 
		<input type="text"
		  name="city"
		  id="city"
			class="typeahead span3" style="margin: 0 auto;" data-provide="typeahead" autocomplete="off"
			data-items="4"
			data-source="[&quot;Alabama&quot;,&quot;Alaska&quot;,&quot;Arizona&quot;,&quot;Arkansas&quot;,&quot;California&quot;,&quot;Colorado&quot;,&quot;Connecticut&quot;,&quot;Delaware&quot;,&quot;Florida&quot;,&quot;Georgia&quot;,&quot;Hawaii&quot;,&quot;Idaho&quot;,&quot;Illinois&quot;,&quot;Indiana&quot;,&quot;Iowa&quot;,&quot;Kansas&quot;,&quot;Kentucky&quot;,&quot;Louisiana&quot;,&quot;Maine&quot;,&quot;Maryland&quot;,&quot;Massachusetts&quot;,&quot;Michigan&quot;,&quot;Minnesota&quot;,&quot;Mississippi&quot;,&quot;Missouri&quot;,&quot;Montana&quot;,&quot;Nebraska&quot;,&quot;Nevada&quot;,&quot;New Hampshire&quot;,&quot;New Jersey&quot;,&quot;New Mexico&quot;,&quot;New York&quot;,&quot;North Dakota&quot;,&quot;North Carolina&quot;,&quot;Ohio&quot;,&quot;Oklahoma&quot;,&quot;Oregon&quot;,&quot;Pennsylvania&quot;,&quot;Rhode Island&quot;,&quot;South Carolina&quot;,&quot;South Dakota&quot;,&quot;Tennessee&quot;,&quot;Texas&quot;,&quot;Utah&quot;,&quot;Vermont&quot;,&quot;Virginia&quot;,&quot;Washington&quot;,&quot;West Virginia&quot;,&quot;Wisconsin&quot;,&quot;Wyoming&quot;]"
			value="${person.city}"
		/>
		
		
		
		
		<div class="form-actions">
		  <button type="submit" class="btn btn-large btn-primary">
        <spring:message code="form.general.submit.title"></spring:message>
      </button>
		</div>
</form:form>
