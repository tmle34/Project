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
<h1>Edit Product</h1>
<form method="post" action="/saveProducts">
    <br> ID:<br>
    <input type="text" name="cuid" value="${selectedItem.getProductSKU()}">
    <br> Products Name:<br>
    <input type="text" name="ProductsName" value="${selectedItem.getProductName()}">
    <br> Products Price: <br>
    <input type = "text" name="price" value = "${selectedItem.getProductPrice()}">
    <input type="hidden" name="id" value="${selectedItem.getProductID()}">
    <br><br>
    <input type="submit" name="Enter">
</form>
</body>
</html>
