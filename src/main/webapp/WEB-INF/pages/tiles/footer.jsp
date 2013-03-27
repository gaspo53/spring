 <%@ include file="../taglibs.jsp" %>
<jsp:useBean id="date" class="java.util.Date" />

      <hr>

      <footer>
        <p>
            &copy; <spring:message code="global.footer.company"></spring:message> 
            <fmt:formatDate value="${date}" pattern="yyyy" />
        </p>
      </footer>
