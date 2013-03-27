 <%@ include file="../taglibs.jsp" %>
               <cw:if test="${not empty message_code}">
                 <div class="alert ${message_class}">
                     <spring:message code="${message_code}"></spring:message>
                 </div>
               </cw:if>
