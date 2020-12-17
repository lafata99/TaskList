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
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>${loggedInUser.firstName }'s profile</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<link rel="stylesheet" href="static/css/profile.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>

<body class="my-profile-page">
	<jsp:include page="header.jsp" />
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">
					<div class="brand">
						<c:if test="${not empty loggedInUser.image}">
							<img
								src="static/img/user/${loggedInUser.id}/profile/${loggedInUser.image}"
								alt="Profile Image">
						</c:if>
						<c:if test="${empty loggedInUser.image}">
							<a href="#" data-toggle="modal" data-target="#addimages"
								class="btn btn-primary"> Add Image</a>
						</c:if>
					</div>
					<div class="row justify-content-md-center">
					<c:if test="${not empty loggedInUser.image}">
						<a href="#" data-toggle="modal" data-target="#addimages"
							class="btn btn-primary"> Change Photo <i class="fa fa-pencil"></i></a>
					</c:if>
					</div>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title">${loggedInUser.firstName}
								${loggedInUser.lastName}'s Profile </h4>
							<form:form action="profile" modelAttribute="user" method="post">
							<div class="form-group">
									<label for="username">Username</label>
									<input id="username" type="text" class="form-control" name="username" placeholder="${ loggedInUser.username}"
									value="<c:out value='${loggedInUser.username }' />" />
									
								</div>
								
								<div class="form-group">
									<label for="FirstName">First Name</label>
									<input id="FirstName" type="text" class="form-control" name="FirstName"placeholder="${ loggedInUser.firstName}" 
									value="<c:out value='${loggedInUser.firstName }' />" />
									
								</div>
								
								<div class="form-group">
									<label for="lastName">Last Name</label>
									<input id="lastName" type="text" class="form-control" name="lastName" placeholder="${ loggedInUser.lastName}" 
									value="<c:out value='${loggedInUser.lastName }' />" />
									
								</div>

								<div class="form-group">
									<label for="email">E-Mail Address</label>
									<input id="email" type="email" class="form-control" name="email" placeholder="${ loggedInUser.email}"
									value="<c:out value='${loggedInUser.email }' />" />
									
								</div>

								<div class="form-group">
									<label for="password">Password</label>
									<input id="password" type="password" class="form-control" name="password" 
									value="<c:out value='${loggedInUser.password }' />" />
									
								</div>
								
								<div class="form-group">
									<label for="repeatpass">Repeat Password</label>
									<input id="repeatpass" type="password" class="form-control" name="repeatpass" 
									value="<c:out value='${loggedInUser.password }' />" />
									
								</div>
								<input type="hidden" name="id" value="${loggedInUser.id}"/>

								

								<div class="form-group m-0">
									<button type="submit" class="btn btn-primary btn-block">
										Update
									</button>
								</div>
								
								
								</form:form>
								
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	


<div class="modal fade" id="addimages" tabindex="-1"
		aria-labelledby="editLabel" aria-hidden="true">
		<div class="modal-dialog">
			
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Edit Task</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>

					<div class="modal-body">
			<form enctype="multipart/form-data" action="addimages" method="POST"
				class="form-horizontal">
				<div class="control-group">

					<div class="controls">
						<label>Please select:</label> <input type="hidden" name="id"
							value="${loggedInUser.id}"> <input id="file" type="file"
							id="two" name="file">
					</div>
				</div>

				<div class="control-group">
					<div class="controls">
						<button type="submit" class="btn btn-primary">Upload</button>
					</div>
				</div>
			</form>
		</div>
					
				</div>
			
		</div>
	</div>









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