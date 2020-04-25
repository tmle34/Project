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

    <h2>Products</h2>
    <table>
        <tr>
            <th> ProductsNum</th>
            <th> ProductsName</th>
        </tr>
        <c:forEach var="listItem" items="${ProductsList}">
            <tr>
                <td>${listItem.getProductSKU()}</td>
                <td>${listItem.getProductName()}</td>
                <td>${listItem.getProductPrice()}</td>
                <td>
                    <a href="/editProducts/${listItem.getProductID()}">Edit</a>
                    <a href="/deleteProducts/${listItem.getProductID()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
    </div>
        <div style="margin-left: 50%; height: 100px;">
            <form method="post" action="/saveProducts">
                <input type="hidden" name="id" value="">
                Products Name: <br>
                <input type ="text" name = "ProductsName">
                ><br> Products Price: <br>
                <input type = "text" name="price">
                <br>
                <input type="submit" name="Submit">
            </form>
    </div>
</div>

<a href = "/">Return</a>
</form>
</body>
</html>
