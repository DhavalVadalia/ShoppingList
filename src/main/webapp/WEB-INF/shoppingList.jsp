<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <p>Hello, ${user} <a href="ShoppingList?action=logout">Logout</a></p>
        
        <h2>List</h2>
        <form action="ShoppingList" method="post">
            <input type="hidden" name="action" value="add">
            <table>
                <tr> <td> <label for="item" > <strong> Add item: </strong> </label> </td>
                    <td><input type="text" name="item" id="item" placeholder="enter the item " required/> </td>
                    <td> <button type="submit">Add</button> </td>
                </tr>
            </table>      
         </form>
        
        <form action="ShoppingList" method="post">
            <input type="hidden" name="action" value="delete">
            <c:forEach items="${items}" var="item">
                <p> 
                   
                    <input type="radio" name="item" value="${item}"/>
                    ${item}
                 
                </p>
            </c:forEach>
            <c:if test="${items.size() != 0}">
                <button type="submit">Delete</button>
            </c:if>
        </form>
    </body>
</html>
