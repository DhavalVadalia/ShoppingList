<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Main Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="ShoppingList" method="post">
             <input type="hidden" name="action" value="register">
             <table> 
                 <tr> <td><label for="username"> <strong> Username:</strong> </label> </td>
                     <td><input type="text" name="user" id="user" /></td>
                     <td><button type="submit">Register name</button> </td>
                 </tr>       
            </table>
        </form>
    </body>
</html>
