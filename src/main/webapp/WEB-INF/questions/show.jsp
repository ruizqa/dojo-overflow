<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Overflow</title>
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
              <a href="/questions" class="nav-link">Dashboard</a>
            </li>
            <li class="nav-item">
              <a href="/questions/new" class="nav-link">New Question</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
	<section class="py-5"></section>	


<section>
	<div class="container">
		<h1 class="text-center"><c:out value="${question.content}"/></h1>
		<h3>Tags:</h3>
			<c:forEach items="${question.tags}" var="tag">
				<span class="m-2 border-dark"><c:out value="${tag.name}"/></span>
			</c:forEach>
		<div class="row">
		<div class="col">
			<table class="table table-hover table-striped">
				<thead class="table-dark">
					<tr>
						<td>Answers</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${question.answers}" var="answer">
							<tr>
							<td><c:out value="${answer.content}"/></td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col">
				<h3>Add your answer:</h3>
				<form action="/questions/${question.id}/addAnswer" method="post" class="col">
				   	 <div class="form-group my-2">
				        <label for="content" class="form-label"></label>
				    </div>
			        <textarea name="content" style = "width:100%"></textarea>
					<input class="btn btn-primary text-center my-2" type="submit" value="Answer it!"/>
				</form>
		</div>
		</div>
	</div>
</section>  



</body>
</html>