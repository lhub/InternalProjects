<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<sj:head jqueryui="true" jquerytheme="redmond" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results Page</title>
</head>
<body>

 <s:url id="remoteurl" action="jsontable"/>
 	
    <sjg:grid
        id="gridtable"
        caption="Employee"
        dataType="json"
        href="%{remoteurl}"
        loadonce="true"
        loadingText="please wait..."
        pager="true"
        pagerButtons="true"
        gridModel="gridModel"
        rowList="15,20,25"
        rowNum="10"
        rownumbers="true"
        sortname="empId"
        sortorder="desc">
        
        <sjg:gridColumn name="empId" index="empId" title="ID" formatter="integer" sortable="true"/>
        <sjg:gridColumn name="empName" index="empName" title="Name" sortable="true"/>
        <sjg:gridColumn name="empDesignation" index="empDesignation" title="Designation" sortable="false"/>
        <sjg:gridColumn name="empDepartment" index="empDepartment" title="Department" sortable="false"/>
        <sjg:gridColumn name="empProject" index="empProject" title="Current Project" sortable="false"/>
    </sjg:grid>

</body>
</html>