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
    </style>
</head>
<body>
<h1>Searching Transactions</h1>
<table>
    <tr>
        <th>Product ID</th>
        <th>Receipt</th>
    </tr>
    <c:forEach var="listItem" items="${tt}">
        <tr>
            <td>${listItem.getProductID()}</td>
            <td>${listItem.getReceipt()}</td>
        </tr>
    </c:forEach>
</table>
<br><br><br>
<a href = "/">Return</a>

</body>
</html>
