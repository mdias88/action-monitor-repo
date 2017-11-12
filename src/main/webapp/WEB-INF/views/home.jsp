
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<script type="text/javascript" src="<c:url value="javascript/libs/jquery-3.2.1.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="javascript/libs/sockjs.js" />"></script>
	<script type="text/javascript" src="<c:url value="javascript/libs/stomp.js" />"></script>
	<script type="text/javascript" src="<c:url value="javascript/actionMonitor.js" />"></script>
	<link href="<c:url value="css/main.css" />" rel="stylesheet">
</head>
<body>

	
	<form method="post" data-contextpath="<%=request.getContextPath()%>" action="">

	<div id="headerContainer" class="col100 header">
		Action-Monitor WebApp
	</div>
	
	<div id="bodyContainer" class="row">
		<div id="leftCol" class="col15"></div>
		<div id="interfaceContainer" class="col30 pad10">
			<div id="rbContainer" class="pad10">
				<h2>Choose a action</h2>
				<input type="radio" name="option" value="insert"> Insert<br>
 				<input type="radio" name="option" value="update"> Update<br>
  				<input type="radio" name="option" value="delete"> Delete
  			</div>
			<div id="insertContainer" class="actionContainer pad10 visible-none">
				<h2>Register an Account</h2>
				Enter Username<input type="text" tabindex="1" name="userNameInsert" maxlength="40"><br> 
				Enter Password <input type="password"  tabindex="2" name="passwordInsert" maxlength="40">
				<input id="submitButtonInert" type="Button" value="Insert"  tabindex="3" />
			</div>
			<div id="updateContainer" class="actionContainer pad10 visible-none">
				<h2>Update an Existing Account</h2>
				Enter Username<input type="text" tabindex="4" name="userNameUpdate" maxlength="40"><br> 
				Enter Password <input type="password"  tabindex="5" name="passwordUpdate" maxlength="40">
				<input id="submitButtonUpdate" type="Button" value="Update"  tabindex="6" />
			</div>
			<div id="deleteContainer" class="actionContainer pad10 visible-none">
				<h2>Delete an Account</h2>
				Enter Username<input type="text" tabindex="7" name="userNameDelete" maxlength="40"> 
				<input id="submitButtonDelete" type="Button" value="Delete"  tabindex="9" />
			</div>
			
		</div>
		<div id="monitorContainer" class="col40 pad10">
			Monitor<textarea readonly></textarea>
		</div>
		<div id="leftCol" class="col15"></div>		
	</div>
	</form>

</body>
</html>
