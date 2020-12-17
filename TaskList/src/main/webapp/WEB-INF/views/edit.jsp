<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="_profile" value="active" />

<c:if test="${empty loggedInUser}">
	<%
		response.sendRedirect("login");
	%>
</c:if>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Edit Task</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<link rel="stylesheet" href="static/css/task.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>

<body class="my-task-page">
	<jsp:include page="header.jsp" />

	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">

					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title">Edit Task</h4>
							<form:form action="editTask" modelAttribute="task" method="post">
								
								<div class="form-group">
									<label for="status">Status</label> <input
										id="status" type="text" class="form-control"
										name="status" required autofocus>
									<div class="invalid-feedback">Description</div>
								</div>
								<div class="form-group m-0">
									<button type="submit" class="btn btn-primary btn-block">
										Edit Task
									</button>
								</div>
								
								
								<div class="form-group">
								<input id="lastModifiedBy" class="visually-hidden" type="hidden" name="lastModifiedBy" value="${loggedInUser.username }">
									
								</div>
							</form:form>

						</div>
					</div>


				</div>

			</div>
		</div>

	</section>







</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="static/js/login.js"></script>
</html>