<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Ticket</title>
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
<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  overflow:hidden;padding:10px 5px;word-break:normal;}
.tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
.tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}
.tg .tg-0lax{text-align:left;vertical-align:top}
</style>
<table class="tg">
<thead>
  <tr>
    <th class="tg-0pky">Ticket ID</th>
    <th class="tg-0lax"><c:out value="${ticket.ticketid}" /></th>
  </tr>
</thead>
<tbody>
  <tr>
    <td class="tg-0lax">Purchase Type</td>
    <td class="tg-0lax"><c:out value="${ticket.typesofpurchase}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Time Frame</td>
    <td class="tg-0lax"><c:out value="${ticket.timeframe}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Product</td>
    <td class="tg-0lax"><c:out value="${ticket.product}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Ticket Date</td>
    <td class="tg-0lax"><c:out value="${ticket.ticketdate}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Min. Budget</td>
    <td class="tg-0lax"><c:out value="${ticket.minbudget}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Max Budget</td>
    <td class="tg-0lax"><c:out value="${ticket.maxbudget}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Comments</td>
    <td class="tg-0lax"><c:out value="${ticket.comments}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Quantity</td>
    <td class="tg-0lax"><c:out value="${ticket.quantity}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Customer ID</td>
    <td class="tg-0lax"><c:out value="${ticket.customerid}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Customer Fullname</td>
    <td class="tg-0lax"><c:out value="${customer.fullname}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Customer Email</td>
    <td class="tg-0lax"><c:out value="${customer.email}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Customer Phone No</td>
    <td class="tg-0lax"><c:out value="${customer.phoneno}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax">Customer Contact Type</td>
    <td class="tg-0lax"><c:out value="${customer.typeofcontact}" /></td>
  </tr>
  <tr>
    <td class="tg-0lax"><a href="TicketController?action=listTicket" class="btn btn-primary">Back</a></td>
    <td class="tg-0lax"><a href="TicketController?action=updateTicket&ticketid=<c:out value="${ticket.ticketid}" />&customerid=<c:out value="${ticket.customerid}" />" class="btn btn-primary">Update</a></td>
  </tr>
  
</tbody>
</table>
</body>
</html>