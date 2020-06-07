<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <body>

<form:form method = "POST" action = "/webui/categories/edit" modelAttribute = "edit">
         <table>
            <tr>
               <td><form:label path = "categoryName">Category Name</form:label></td>
               <td><form:input path = "categoryName" value = "${categoryBean.categoryName}"/></td>
               <tr>
                             <td></td>
                             <td><form:hidden path = "categoryId" value = "${categoryBean.categoryId}" /></td>
                           </tr>
            </tr>
            <tr>
                           <td></td>
                           <td><input type="submit" value="EDIT" /></td>
                        </tr>
             </table>
</form:form>
   </body>
</html>