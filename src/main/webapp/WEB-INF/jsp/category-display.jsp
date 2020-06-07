<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <body>
   <table>
     <c:forEach var="category" items="${categories}">
         <tr>
           <td><c:out value="${category.categoryId}" /></td>
           <td><c:out value="${category.categoryName}" /></td>
           <td><a href="/webui/categories/edit/<c:out value='${category.categoryId}' />">Edit</a>
                                       &nbsp;&nbsp;&nbsp;&nbsp;
                                       <a href="/webui/categories/delete/<c:out value='${category.categoryId}' />">Delete</a>   </td>
         </tr>
     </c:forEach>
     </table>
   </body>
</html>