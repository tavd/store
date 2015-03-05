<%@ page session="false" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

    <body>

    <%--<c:if test="${!empty itemList}">--%>
        <table class="item-table">
       <tr>
              <th>Name</th>
              <th>Desscription</th>
              <th>Category</th>
              <th>Price</th>
       </tr>

            <c:forEach items="${itemList}" var="item">
              <tr>
                       <td>${item.name}</td>
                       <td>${item.description}</td>
                       <td>${item.category}</td>
                       <td>${item.prce}</td>
                </tr>
            </c:forEach>

        </table>
    <%--</c:if>--%>


    </body>
</html>
