<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Student</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

    <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 fixed-top">
      <div class="container">
        <a href="#" class="navbar-brand">Dojo Overflow</a>

        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navmenu"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navmenu">
          <ul class="navbar-nav ms-auto">
            <li class="nav-item">
              <a href="/questions" class="nav-link">Question Dashboard</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <section class="py-5"></section>
<section>
	<div class="container">
		<div class="col-lg-6 offset-lg-3">
			<h1>What is your question?</h1>
			<p>Please enter your question. Tags must be comma separated values in lower case.</p>
			<form:form action="/questions" method="post" modelAttribute="question" class="col">
			    <div class="form-group my-2">
			        <form:label path="content" class="form-label">Question</form:label>
			    </div>
			    <div class="form-group my-2">    
			        <form:errors path="content"/>
			        <form:input path="content" class="form-control"/>
			    </div>
			    
			    <div class="form-group my-2">
			        <form:label path="tag_values" class="form-label">Tags</form:label>
			    </div>
			    <div class="form-group my-2">    
			        <form:errors path="tag_values"/>
			        <form:input path="tag_values" class="form-control"/>
			    </div>			    
   
			    <div class="text-center">    
			    	<input class="btn btn-primary text-center my-2" type="submit" value="Submit"/>
			    </div>
			</form:form>
		</div>	
	</div>
</section>
</body>
</html>