<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Customer Management</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

 <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="http://localhost:8080/TravelExperts/" class="navbar-brand"> Travel Experts </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Customers</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
           

                <div class="container">
                    <h3 class="text-center">List of Customers</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
     New Customer</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Customer ID</th>
                                <th>FirstName</th>
                                <th>LastName</th>
                                <th>Address</th>
                                <th>City</th>
                                <th>Province</th>
                                <th>Postal</th>
                                <th>Country</th>
                                <th>Home Phone</th>
                                <th>Business Phone</th>
                                <th>Email</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach var="customer" items="${listCustomer}">

                                <tr>
                                    <td>
                                        <c:out value="${customer.customerId}" />
                                    </td>
                                    <td>
                                        <c:out value="${customer.custFirstName}" />
                                    </td>
                                    <td>
                                        <c:out value="${customer.custLastName}" />
                                    </td>
                                    <td>
                                        <c:out value="${customer.custAddress}" />
                                    </td>
                                     <td>
                                        <c:out value="${customer.custCity}" />
                                    </td>
                                     <td>
                                        <c:out value="${customer.custProv}" />
                                    </td>
                                     <td>
                                        <c:out value="${customer.custPostal}" />
                                    </td>
                                     <td>
                                        <c:out value="${customer.custCountry}" />
                                    </td>
                                     <td>
                                        <c:out value="${customer.custHomePhone}" />
                                    </td>
                                     <td>
                                        <c:out value="${customer.custBusPhone}" />
                                    </td>
                                    
                                     <td>
                                        <c:out value="${customer.custEmail}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${customer.customerId}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
                                    <a href="delete?id=<c:out value='${customer.customerId}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                           
                        </tbody>

                    </table>
                </div>
            </div>

</body>

</html>