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
              <a href="/questions/new" class="nav-link">New Question</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
	<section class="py-5"></section>	


<section>
	<div class="container">
		<h1 class="text-center">Questions Dashboard</h1>
		<div class="col-lg-6 offset-lg-3">
			<table class="table table-striped table-hover">
				<thead class="table-dark">
					<tr>
						<td>Question</td>
						<td>Tags</td>
					</tr>
				</thead>
				<tbody>
					
						<c:forEach items="${questions}" var="question">
								<tr>
								<td><a href="/questions/${question.id}"><c:out value="${question.content}"/></a></td>
								<td>
									<c:forEach items="${question.tags}" var="tag">
										<c:out value=" ${tag.name} "/>
									</c:forEach>
								</td>
								</tr>
						</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
</section> 



</body>
</html>