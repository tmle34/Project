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
    </style>
</head>
<body>
<h1>Edit Customer</h1>
<form method="post" action="/save">
    <br> ID:<br>
    <input type="text" name="cuid" value="${selectedItem.getCustomerNum()}">
    <br> Customer Name:<br>
    <input type="text" name="CustomerName" value="${selectedItem.getCustomerName()}">
    <input type="hidden" name="id" value="${selectedItem.getCustomerID()}">
    <br><br>
    <input type="submit" name="Enter">
</form>
</body>
</html>
