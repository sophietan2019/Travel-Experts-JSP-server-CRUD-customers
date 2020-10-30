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
                        <a href="https://www.javaguides.net" class="navbar-brand"> Customer Management </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Customers</a></li>
                    </ul>
                </nav>
    </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${customer != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${customer == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${customer != null}">
                                    Edit Customer
                                </c:if>
                                <c:if test="${customer == null}">
                                    Add New Customer
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${customer != null}">
                            <input type="hidden" name="customerId" value="<c:out value='${customer.customerId}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>First Name</label> <input type="text" value="<c:out value='${customer.custFirstName}' />" 
                            class="form-control" name="custFirstName" >
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Last Name</label> <input type="text" value="<c:out value='${customer.custLastName}' />" 
                            class="form-control" name="custLastName" >
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Address</label> <input type="text" value="<c:out value='${customer.custAddress}' />" 
                            class="form-control" name="custAddress">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>City</label> <input type="text" value="<c:out value='${customer.custCity}' />" 
                            class="form-control" name="custCity">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Province</label> <input type="text" value="<c:out value='${customer.custProv}' />" 
                            class="form-control" name="custProv">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Postal</label> <input type="text" value="<c:out value='${customer.custPostal}' />" 
                            class="form-control" name="custPostal">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Country</label> <input type="text" value="<c:out value='${customer.custCountry}' />" 
                            class="form-control" name="custCountry">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Home Phone</label> <input type="text" value="<c:out value='${customer.custHomePhone}' />" 
                            class="form-control" name="custHomePhone">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Business Phone</label> <input type="text" value="<c:out value='${customer.custBusPhone}' />" 
                            class="form-control" name="custBusPhone">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="<c:out value='${customer.custEmail}' />" 
                            class="form-control" name="custEmail" >
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>

</body>

</html>