<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h2>Product List</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Category</th>
        <th>Price</th>
        <th>Stock Quantity</th>
        <th>Active</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="productList" scope="request" type="java.util.List"/>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.category}</td>
            <td>${product.price}</td>
            <td>${product.stockQuantity}</td>
            <td>${product.isActive}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
