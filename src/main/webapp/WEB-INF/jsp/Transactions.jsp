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
        select {
            width: 150px;
            margin: 12px;
        }
    </style>
</head>
<body>
<div style="width: 100%;">
    <div style="width: 50%; float: left;">

    <h2>Transactions</h2>
    <table>
        <tr>
            <th>Employee ID</th>
            <th>Product ID</th>
            <th>Customer ID</th>
            <th>Receipt</th>
        </tr>
        <c:forEach var="listItem" items="${TransactionsList}">
            <tr>
                <td>${listItem.getEmployeeID()}</td>
                <td>${listItem.getProductID()}</td>
                <td>${listItem.getCustomerID()}</td>
                <td>${listItem.getReceipt()}</td>
                <td>
                    <a href="/editTransaction/${listItem.getReceipt()}">Edit</a>
                    <a href="/deleteTransaction/${listItem.getReceipt()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
    </div>
        <div style="margin-left: 50%; height: 100px;"><form method = "post" action = "/saveTransactions">
            <input type="hidden" name="id" value="">
            Customer Name: <br>
            <select name = "CustomerID">
                <c:forEach var="listItem" items="${CustomerList}">
                <option value = ${listItem.getCustomerName()}>${listItem.getCustomerName()}</c:forEach>
            </select>
            <br>Product Name: <br>
            <select name = "ProductID">
                <c:forEach var="listItem" items="${ProductsList}">
                <option value = ${listItem.getProductName()}>${listItem.getProductName()}</c:forEach>
            </select>
            <br>EmployeeName: <br>
            <select name = "EmployeeID">
                <c:forEach var="listItem" items="${EmployeeList}">
                <option value = ${listItem.getEmployeeName()}>${listItem.getEmployeeName()}</c:forEach>
            </select>
            <br>Receipt Num Limit 10 Characters(Only Num)<br>
            <input type = "text" name = ReceiptNum>
            <input type = "submit" name = "submit">

        </form>
    </div>
</div>
<br><br><br>
<a href = "/">Return</a>
</form>
</body>
</html>
