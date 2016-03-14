
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!DOCTYPE>
<html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%> 
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<head>
<sj:head jqueryui="true" 
         jquerytheme="customTheme" 
         customBasepath="template/"/> 

</head>
<body>
<h2>StrutsCrudOperation</h2>
<s:if test="hasActionMessages()">
   <div class="welcome">
      <s:actionmessage/>
   </div>
</s:if>

	


<s:form action="register" method="post">
<s:textfield name="name" label="Name" ></s:textfield>
<s:textfield name="emailId" label="EmailId" ></s:textfield>
<s:textfield name="mobile" label="Mobile" ></s:textfield>
<s:submit value="submit"></s:submit>
</s:form>

<!-- <div class="col-md-5"> -->
		 <s:url id="remoteurl" action="personDetailsData.action"  escapeAmp="false"/>  
   <s:url id="editurl" action="update"/>
   <%-- <s:url id="deleteURL" action="delete" /> --%>
	<sjg:grid
	    id="gridtable" 
	    caption="Person Details"
	  	dataType="json"
		href="%{remoteurl}"
		pager="true" 
		gridModel="persondetailsList" 
		loadonce="false"
		rowNum="100"
		navigator="true" 
		navigatorAdd="false" 
		navigatorDelete="true"
		navigatorEdit="true" 
		navigatorEditOptions="{addCaption:'EDIT',height:600,width:250,reloadAfterSubmit:false,closeAfterEdit:true}"
		navigatorDeleteOptions="{height:180,reloadAfterDelete:false,closeAfterDelete:true}"
		navigatorRefresh="true" 
		navigatorSearch="true"
		navigatorView="false" 
		rowList="20,30,40,50,60,100"
		viewrecords="true" 
		onSelectRowTopics="rowselect" 
		editurl="%{editurl}"
		editinline="false" 
   		rownumbers="true"
   		sortable="true"
   		sortname="id" 
   		sortorder="asc"
		autowidth="true"
		height="300"
		>
 		<sjg:gridColumn name="id" hidden="true"  search="false" key="true" index="Id" title="Event ID" sortable="true" />
 			<sjg:gridColumn name="name" align="left" width="100" index="Name" title="Name"  sortable="true" editable="true" editoptions="{maxlength:'120'}" editrules="{required: true}"/>
			<sjg:gridColumn name="emailId" align="left" width="100" index="Email Id" title="Email ID" sortable="true" editable="true" editrules="{required: true}"/>
			<sjg:gridColumn name="mobile" align="left" width="100" index="MObile" title="Mobile" sortable="true" editable="true" editoptions="{maxlength:'600'}" editrules="{required: true}"/>
			<sjg:gridColumn name="createdDate" align="left" width="100"  index="CreatedDate" title="created Date" sortable="true" editable="true" editoptions="{maxlength:'3000'}" editrules="{required: true}"/>
			<sjg:gridColumn name="modifiedDate" align="left" width="100"  index="ModifiedDate" title="Modified Date" sortable="true" editable="true" />
	</sjg:grid>
		<!-- </div> -->


<%-- <!-- <table border="1">
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Email</th>
	<th>Mobile</th>
	<th>Created Date</th>
	<th>Modified Date</th>
	<th> Edit/Update</th>
	<th> Delete</th>
</tr> -->
 <s:iterator value="persondetailsList" status="personStatus">
 <tr
class="<s:if test="#personStatus.odd == true ">odd</s:if> <s:else>even</s:else>">
<td><s:property value="id" /></td>
<td><s:property value="name" /></td>
<td><s:property value="emailId" /></td>
<td><s:property value="mobile" /></td>
<td><s:property value="createdDate" /></td>
<td><s:property value="modifiedDate" /></td>
<td>
<s:url id="editURL" action="update">
<s:param name="id" value="%{id}"></s:param>
<s:param name="name" value="%{name}"></s:param>
<s:param name="emailId" value="%{emailId}"></s:param>
<s:param name="mobile" value="%{mobile}"></s:param>
</s:url>
<s:a href="%{editURL}">Edit</s:a>
</td>
<td>
<s:url id="deleteURL" action="delete">
<s:param name="id" value="%{id}"></s:param>
</s:url>
<s:a href="%{deleteURL}">Delete</s:a>
</td>
</tr>
  <tr>
  <td><s:property value="id"/> </td>
  <td><s:property value="name"/> </td> 
  <td><s:property value="emailId"/></td>
   <td><s:property value="mobile"/></td>
  <td><s:property value="createdDate"/></td>
  <td><s:property value="modifiedDate"/></td>
  <td><s:url action="update" var="edit"></s:url><s:a href="%{edit}">edit?</s:a></td>  
  <td><s:url action="delete" var="dlt"></s:url><s:a href="%{dlt}">Delete?</s:a></td>
  </tr>
</s:iterator>
</table> --%>
</body>
</html>
