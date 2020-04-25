<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Oof</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        h1{
            font-size: large;
        }
        h2{
            font-size: medium;
        }
        select {
            width: 150px;
            margin: 12px;
        }
    </style>
</head>
<body>
<h1>Edit Transaction</h1>
<form method="post" action="/saveTransactions2">
    <br> ID:<br>
    <input type="text" name="cuid" value="${selectedItem.getReceipt()}">
    <br>Customer Name: <br>
    <select name = "CustomerID">
        <c:forEach var="listItem" items="${TransactionsList}">
        <option value = ${listItem.getCustomerID()}>${listItem.getCustomerID()}</c:forEach>
    </select>
    <br>Product Name: <br>
    <select name = "ProductID">
        <c:forEach var="listItem" items="${TransactionsList}">
        <option value = ${listItem.getProductID()}>${listItem.getProductID()}</c:forEach>
    </select>
    <br>EmployeeName: <br>
    <select name = "EmployeeID">
        <c:forEach var="listItem" items="${TransactionsList}">
        <option value = ${listItem.getEmployeeID()}>${listItem.getEmployeeID()}</c:forEach>
    </select>
    <br><br>
    <input type="submit" name="Enter">
</form>
</body>
</html>
