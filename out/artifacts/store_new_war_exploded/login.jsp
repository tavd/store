<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Login Page</title>
</head>

<body>

<div id="login-box">
    <form action="Login"
          method='POST'>
        <table>
            <tr>
                <td>Login:</td>
                <td><input type='text' name='login'></td>

            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password'/></td>
            </tr>

            <tr>
                <td colspan='3'><span class="login-button">
                        <input name="submit" type="submit"
                               value="submit"/></span></td>
            </tr>

        </table>

    </form>

</div>
<br>
If you are new user, please <a href="register.jsp">register</a>.

</body>
</html>