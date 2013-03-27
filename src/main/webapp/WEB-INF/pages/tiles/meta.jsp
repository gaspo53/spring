<%@ include file="../taglibs.jsp"%>

<meta charset="utf-8">
<title>
    <cw:set var="page_title"> 
        <tiles:insertAttribute name="page_title" ignore="true" defaultValue="SpringMVC"/>
    </cw:set>
   
   <spring:message code="${page_title}"></spring:message>
</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
