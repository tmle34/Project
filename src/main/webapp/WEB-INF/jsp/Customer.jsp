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
<div style="width: 100%;">
    <div style="width: 50%; float: left;">

    <h2>Customers</h2>
    <table>
        <tr>
            <th> CustomerNum</th>
            <th> CustomerName</th>
        </tr>
        <c:forEach var="listItem" items="${customerList}">
            <tr>
                <td>${listItem.getCustomerNum()}</td>
                <td>${listItem.getCustomerName()}</td>
                <td>
                    <a href="/editCustomer/${listItem.getCustomerID()}">Edit</a>
                    <a href="/delete/${listItem.getCustomerID()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
    </div>
        <div style="margin-left: 50%; height: 100px;">
            <form method="post" action="/save">
                <input type="hidden" name="id" value="">
                Employee Name: <br>
                <input type ="text" name = "CustomerName">
                <br>
                <input type="submit" name="Submit">
            </form>
    </div>
</div>

<a href = "/">Return</a>
</form>
</body>
</html>
