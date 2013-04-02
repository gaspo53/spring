 <%@ include file="../taglibs.jsp" %>
 
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#"><tiles:insertAttribute name="title" ignore="true" defaultValue="SpringMVC"/></a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              <a href="${contextPath}/j_spring_security_logout" class="navbar-link">
                  <spring:message code="layout.menu.logout_title"></spring:message>
              </a>
            </p>
            
            <ul class="nav">
              <li id="menu_item_person">
                  <a href="${contextPath}/person"><spring:message code="layout.menu.person_title"></spring:message></a>
              </li>
              <li id="menu_item_student">
                  <a href="${contextPath}/student"><spring:message code="layout.menu.student_title"></spring:message></a>
              </li>
              <li id="menu_item_superadmin">
                  <a href="${contextPath}/superadmin"><spring:message code="layout.menu.superadmin_title"></spring:message></a>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    
    <script>
      try{
		    var menu_item = document.getElementById('<tiles:insertAttribute name="menu_item_id" ignore="true"/>');
		    menu_item.className = menu_item.className + " active";
      }
      catch(error){
    	  
      }
    </script>