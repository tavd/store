<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<c:url value='/reg'/>--%>
<body>
<form
      action="reg"
      method='POST'>

    <div class="form">
        <table>
            <tr>
                <td>First Name:</td>
                <td><input type='text' name='firstname'></td>

            </tr>

            <tr>
                <td>Last Name:</td>
                <td><input type='text' name='lastname'></td>
            </tr>

            <%--<tr>--%>
            <%--<td>Gender:</td>--%>
            <%--<td>--%>
            <%--<input type="radio" name="optionsRadios" id="optionsRadios1"--%>
            <%--value="Male" checked>--%>
            <%--</td>--%>
            <%--</tr>--%>

            <tr>
                <td>Email:</td>
                <td><input type="email" name="email"/></td>
            </tr>

            <tr>
                <td>Login:</td>
                <td><input type="login" name="login"/></td>
            </tr>

            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"/></td>
            </tr>

            <tr>
                <td>Confirm Password:</td>
                <td><input type="password" name="confirmPassword"/></td>
            </tr>

            <%--<tr>--%>
                <%--<td>Birthdate:</td>--%>
                <%--<td><input type="date" path="birthdate"/></td>--%>
            <%--</tr>--%>

            <tr>
                <td>Country:</td>
                <td><input type='text' name="country"/></td>
            </tr>

            <tr>
                <td>City:</td>
                <td><input type='text' name="city"/></td>
            </tr>

            <tr>
                <td>Sreet:</td>
                <td><input type='text' name="street"/></td>
            </tr>

            <tr>
                <td>Zip code:</td>
                <td><input type='text' name="zipcode"/></td>
            </tr>

            <tr>
                <td>Telephone:</td>
                <td><input type='text' name="telephone" maxlength="10"
                           placeholder="Ex:95xxxx4104"></td>
            </tr>

            <%--<tr>--%>
            <%--<td>Comment:</td>--%>
            <%--<td><textarea type="comment" rows="5" cols="22" name="text"/></td>--%>
            <%--</tr>--%>

            <tr>
                <td colspan="3"><span class="signup-button">
                        <input type="submit" value="register"/></span>
                </td>
            </tr>
        </table>
    </div>

</form>
</body>