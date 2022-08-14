<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Ticket</title>
<link href="./helpdeskcss.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<nav
		class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">



		<div class="topbar-divider d-none d-sm-block"></div>
		<img
			src="https://hybrismedianonprods1.blob.core.windows.net/sys-master-phoenix-images-container/h6c/h6b/9559620911134/razer-ths-logo.svg"
			alt="Razer Logo" style="width: 5%; height: 5%;"> <span
			class="mr-2 d-none d-lg-inline text-gray-600 small">Home</span>


	</nav>
	<div class="container">
		<div class="col-sm-6">
			<form method="post" action="TicketController">
				<div class="form-group">
					<label for="ticketid">Ticket ID</label> <input id="ticketid"
						name="ticketid" type="text" required="required"
						value="<c:out value="${ticket.ticketid}"/>" readonly
						class="form-control">
				</div>
				<div class="form-group">
					<label for="fullname">Full name</label> <input id="fullname"
						name="fullname" type="text" required="required"
						value="<c:out value="${customer.fullname}"/>" class="form-control">
				</div>
				<div class="form-group">
					<label for="phoneno">Phone No</label> <input id="phoneno"
						name="phoneno" type="tel" required="required"
						value="<c:out value="${customer.phoneno}"/>" class="form-control">
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input id="email" name="email"
						type="email" required="required"
						value="<c:out value="${customer.email}"/>" class="form-control">
				</div>
				<div class="form-group">
					<div class="form-group">
						<label for="contact-type">Prefer Contact By:</label> <input
							id="contact-type" name="contact-type" type="text"
							required="required"
							value="<c:out value="${customer.typeofcontact}"/>" readonly
							class="form-control">
					</div>
				</div>
				<div class="form-group">
					<div class="form-group">
						<label for="ticketid">Types of Purchase:</label> <input
							id="purchase-type" name="purchase-type" type="text"
							required="required"
							value="<c:out value="${ticket.typesofpurchase}"/>" 
							class="form-control">
					</div>
				</div>
				<!-- 
				<div class="form-group">
					<label for="date">Date</label> <input id="date" name="date"
						type="date" required="required" class="form-control">
				</div>
				 -->
				<div class="form-group">
					<label for="min-budget">Minimum Budget</label> <input
						id="min-budget" name="min-budget" type="number" min="0"
						step="0.01" value="<c:out value="${ticket.minbudget}"/>"
						class="form-control">
				</div>
				<div class="form-group">
					<label for="max-budget">Maximum Budget:</label> <input
						id="max-budget" name="max-budget" type="number" min="0"
						step="0.01" value="<c:out value="${ticket.maxbudget}"/>"
						class="form-control">
				</div>
				<div class="form-group">
					<div class="form-group">
						<label for="time-frame">Time Frame:</label> <input
							id="time-frame" name="time-frame" type="text"
							required="required"
							value="<c:out value="${ticket.timeframe}"/>" 
							class="form-control">
					</div>
				</div>
				<div class="form-group">
					<div class="form-group">
						<label for="product">Interested to buy:</label> <input
							id="product" name="products" type="text"
							required="required"
							value="<c:out value="${ticket.product}"/>" 
							class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="quantity">Product Quantity:</label> <input
						id="quantity" name="quantity" type="number" value="<c:out value="${ticket.quantity}"/>" class="form-control">
				</div>
				<div class="form-group">
					<label for="comment">Please indicate any value code or
						products you are interested in. Comments, Enquiries, Instructions:</label>
					<textarea id="comment" name="comment" cols="40" rows=""
						value="<c:out value="${ticket.comments}"/>" class="form-control"></textarea>
				</div>
				<div class="form-group">
				 <a href="TicketController?action=listTicket" class="btn btn-primary">Back</a>
				</div>
				<div class="form-group">
					<button name="submit" type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>