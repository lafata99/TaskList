<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="_profile" value="active" />



<header>

	<!--Navbar-->
	<nav class="navbar fixed-top navbar-dark bg-primary">

		<c:if test="${empty loggedInUser }">
			
			<a class="navbar-brand" href="login">TaskList</a>
			
		</c:if>

		<c:if test="${not empty loggedInUser }">
		
			<a class="navbar-brand" href="tasks">TaskList</a>
			
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent15"
				aria-controls="navbarSupportedContent15" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			
			<div class="collapse navbar-collapse" id="navbarSupportedContent15">


				<!-- Links -->
				<ul class="navbar-nav mr-auto">
		
					<li class="nav-item"><a class="nav-link" href="newtask">Create New Task</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="profile">Profile</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="logout">Sign Out</a>
					</li>
				</ul>


			</div>

		</c:if>



	</nav>

</header>

