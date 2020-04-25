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

    <h2>Employees</h2>
    <table>
        <tr>
            <th> EmployeeNum</th>
            <th> EmployeeName</th>
        </tr>
        <c:forEach var="listItem" items="${EmployeeList}">
            <tr>
                <td>${listItem.getEmployeeNum()}</td>
                <td>${listItem.getEmployeeName()}</td>
                <td>
                    <a href="/editEmployees/${listItem.getEmployeeID()}">Edit</a>
                    <a href="/deleteEmployee/${listItem.getEmployeeID()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
    </div>
        <div style="margin-left: 50%; height: 100px;">
            <form method="post" action="/saveEmployee">
                <input type="hidden" name="id" value="">
                Employee Name: <br>
                <input type ="text" name = "EmployeeName">
                <br>
                <input type="submit" name="Submit">
            </form>
    </div>
</div>

<a href = "/">Return</a>
</form>
</body>
</html>
