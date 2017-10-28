<!DOCTYPE HTML>
<html>
<head> 
    <title>Spring Freemarker</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
      <link rel="stylesheet" href="/css/bootstrap.min.css" /> 
     <!--<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"/>-->
</head>
<body>
<div class="container">
     <div class="control-group">	
		<h2 class="muted">Registration</h2>
    	<form name="person" action="addPerson" method="post">
    		 <div class="control-group">
    		 	<label class="control-label" for="userName">User Name</label>
    		 </div>
    		 <div class="controls">
    		 	<input type="text" name="userName">
    		 </div>
    		<div class="control-group">
    			<label class="control-label" for="password">Password</label>
    		 </div>	
    		 <div class="controls">
    		 	<input type="password" name="password">
    		 </div>
    		  <div class="control-group">
    		 	 <label class="control-label" for="email">Email </label>
    		 </div>	
    		
    		<div class="controls">
    		 	<input type="text" name="email">
    		 </div>
    		<div class="controls"> 
    			<input type="submit" class="btn btn-primary">
    		</div>
    	</form>
	 </div>
	<div>
	<#if persons?size != 0 >
    <table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>User Name</th>
				<th>Email</th>
				
			</tr>
		</thead>
		<tbody>
			<#list persons as person>
				<tr>
					<td>${person.id}</td>
					<td>${person.userName}</td>
					<td>${person.email}</td>
				</tr>
			</#list>
		</tbody>
    </table>
    </#if>
    </div>
</div>	
</body>
</html>